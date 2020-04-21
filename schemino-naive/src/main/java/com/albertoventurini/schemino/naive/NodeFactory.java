package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.nodes.BooleanNode;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.nodes.LambdaNode;
import com.albertoventurini.schemino.naive.nodes.ListNode;
import com.albertoventurini.schemino.naive.nodes.LongNode;
import com.albertoventurini.schemino.naive.nodes.ProgramNode;
import com.albertoventurini.schemino.naive.nodes.ReadVariableNode;
import com.albertoventurini.schemino.naive.nodes.StringNode;
import com.albertoventurini.schemino.naive.nodes.SymbolNode;
import com.albertoventurini.schemino.naive.nodes.WriteVariableNode;
import com.albertoventurini.schemino.parser.ScheminoParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for creating program nodes that contain the semantics of
 * the program to execute.
 *
 * The entry point is the AST that was created by the ANTLR4 parser.
 */
public class NodeFactory {

    /**
     * Create a program node, i.e. the root node of the program.
     * @param parser the ANTLR4 parser that contains the AST
     * @return the root node of the program
     */
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
        } else if (ctx.string() != null) {
            return visitString(ctx.string());
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

    private ExpressionNode visitString(final ScheminoParser.StringContext ctx) {
        final String text = ctx.getText();

        try {
            if (text.charAt(0) == '"' && text.charAt(text.length() - 1) == '"') {
                return new StringNode(text.substring(1, text.length() - 1));
            }
        } catch (Exception e) {
            throw new RuntimeException("String processing failed for input " + ctx, e);
        }

        throw new RuntimeException("Invalid string: " + ctx);
    }

    private ExpressionNode visitList(final ScheminoParser.ListContext ctx) {
        if (ctx.expressions().expression().isEmpty()) {
            return new ListNode(Collections.emptyList());
        }

        if (ctx.expressions().expression(0).atom() != null
            && ctx.expressions().expression(0).atom().keyword() != null
            && ctx.expressions().expression(0).atom().keyword().define() != null) {

            // Handle list starting with the 'define' keyword
            return handleDefineList(ctx.expressions());
        }

        if (ctx.expressions().expression(0).atom() != null
                && ctx.expressions().expression(0).atom().keyword() != null
                && ctx.expressions().expression(0).atom().keyword().lambda() != null) {

            // Handle list starting with the 'lambda' keyword
            return handleLambdaList(ctx.expressions());
        }

        // Handle plain list
        return handlePlainList(ctx.expressions());
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

    private ExpressionNode handlePlainList(final ScheminoParser.ExpressionsContext ctx) {
        final List<ExpressionNode> items = ctx.expression()
                .stream()
                .map(this::visitExpression)
                .collect(Collectors.toUnmodifiableList());

        return new ListNode(items);
    }
}
