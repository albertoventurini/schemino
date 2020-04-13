package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.nodes.BooleanNode;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.nodes.FunctionCallNode;
import com.albertoventurini.schemino.naive.nodes.LambdaNode;
import com.albertoventurini.schemino.naive.nodes.ListNode;
import com.albertoventurini.schemino.naive.nodes.LongNode;
import com.albertoventurini.schemino.naive.nodes.ProgramNode;
import com.albertoventurini.schemino.naive.nodes.ReadVariableNode;
import com.albertoventurini.schemino.naive.nodes.SymbolNode;
import com.albertoventurini.schemino.naive.nodes.WriteVariableNode;
import com.albertoventurini.schemino.parser.ScheminoParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NodeFactory {

    public ProgramNode createProgramNode(final ScheminoParser parser) {
        return visitProgram(parser.program());
    }

    private ProgramNode visitProgram(final ScheminoParser.ProgramContext ctx) {
        final var exprs = visitExpressions(ctx.expressions());

        return new ProgramNode(exprs);
    }

    private List<ExpressionNode> visitExpressions(final ScheminoParser.ExpressionsContext ctx) {
        return ctx.expression().stream().map(this::visitExpression).collect(Collectors.toUnmodifiableList());
    }

    private ExpressionNode visitExpression(final ScheminoParser.ExpressionContext ctx) {
        if (ctx.list() != null) {
            return visitList(ctx.list());
        } else if (ctx.atom() != null) {
            return visitAtom(ctx.atom());
        }

        throw new RuntimeException("Unable to create an expression for context: " + ctx);
    }

    private ExpressionNode visitAtom(final ScheminoParser.AtomContext ctx) {
        if (ctx.number() != null) {
            return visitNumber(ctx.number());
        } else if (ctx.keyword() != null) {
            // do something
        } else if (ctx.symbol() != null) {
            return visitSymbol(ctx.symbol());
        } else if (ctx.bool() != null) {
            return visitBoolean(ctx.bool());
        }

        throw new RuntimeException("Unable to create an atom for context: " + ctx.getText());
    }

    private ExpressionNode visitSymbol(final ScheminoParser.SymbolContext ctx) {
        return new ReadVariableNode(new SymbolNode(ctx.getText()));
    }

    private ExpressionNode visitNumber(final ScheminoParser.NumberContext ctx) {
        try {
            final long value = Long.parseLong(ctx.getText());
            return new LongNode(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid number: " + ctx);
        }
    }

    private ExpressionNode visitBoolean(final ScheminoParser.BoolContext ctx) {
        final String text = ctx.getText();
        if (text.equals("true") || text.equals("false")) {
            return new BooleanNode(Boolean.parseBoolean(text));
        }

        throw new RuntimeException("Invalid boolean: " + ctx);
    }

    private ExpressionNode visitList(final ScheminoParser.ListContext ctx) {
        if (ctx.expressions().isEmpty()) {
            return new ListNode(Collections.emptyList());
        }

        if (ctx.expressions().expression(0).getText().equals("define")) {
            return handleDefineList(ctx.expressions());
        }

        if (ctx.expressions().expression(0).getText().equals("lambda")) {
            return handleLambdaList(ctx.expressions());
        }

        return handleFunctionCallList(ctx.expressions());
    }

    private ExpressionNode handleDefineList(final ScheminoParser.ExpressionsContext ctx) {
        final SymbolNode symbolNode = new SymbolNode(ctx.expression(1).getText());
        final ExpressionNode expressionNode = visitExpression(ctx.expression(2));
        return new WriteVariableNode(symbolNode, expressionNode);
    }

    private ExpressionNode handleLambdaList(final ScheminoParser.ExpressionsContext ctx) {
        final List<String> parameters = ctx.expression(1).list().expressions().expression()
                .stream()
                .map(ParseTree::getText)
                .collect(Collectors.toUnmodifiableList());

        final ExpressionNode body = visitExpression(ctx.expression(2));
        return new LambdaNode(parameters, body);
    }

    private ExpressionNode handleFunctionCallList(final ScheminoParser.ExpressionsContext ctx) {
        // Assume that the first element of the list is an expression that will evaluate to the function to call
        final ExpressionNode function = visitExpression(ctx.expression(0));

        final List<ExpressionNode> arguments = ctx.expression()
                .stream()
                .skip(1)
                .map(this::visitExpression)
                .collect(Collectors.toUnmodifiableList());

        return new FunctionCallNode(function, arguments);
    }

}
