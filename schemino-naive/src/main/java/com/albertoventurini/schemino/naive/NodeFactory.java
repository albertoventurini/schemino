package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.nodes.AddNode;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NodeFactory {

    public ProgramNode createProgramNode(final ScheminoParser parser) {
        return visitProgram(parser.program());
    }

    private ProgramNode visitProgram(final ScheminoParser.ProgramContext ctx) {
        var exprs = ctx.expression()
                .stream()
                .map(this::visitExpression).collect(Collectors.toUnmodifiableList());

        return new ProgramNode(exprs);
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
        if (ctx.expression().isEmpty()) {
            return new ListNode(Collections.emptyList());
        }

        if (ctx.expression(0).getText().equals("define")) {
            return new WriteVariableNode(
                    new SymbolNode(ctx.expression(1).getText()),
                    visitExpression(ctx.expression(2))
            );
        }

        if (ctx.expression(0).getText().equals("lambda")) {

            List<String> parameters = new ArrayList<>();

            // A brutal way to exclude the first and last tokens, which are parentheses
            // TODO: refactor massively (probably using Antlr visitors / listeners)

            List<ParseTree> parameterList = ctx.expression(1).list().children;

            for (int i = 1; i < parameterList.size() - 1; i++) {
                parameters.add(parameterList.get(i).getText());
            }

            return new LambdaNode(parameters, visitExpression(ctx.expression(2))
            );
        }

        return new FunctionCallNode(
                visitExpression(ctx.expression(0)),
                ctx.expression().stream().skip(1).map(e -> visitExpression(e)).collect(Collectors.toList()));
    }

}
