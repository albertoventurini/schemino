package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.nodes.BlockNode;
import com.albertoventurini.schemino.naive.nodes.BooleanNode;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.nodes.FunctionCallNode;
import com.albertoventurini.schemino.naive.nodes.LambdaNode;
import com.albertoventurini.schemino.naive.nodes.ListNode;
import com.albertoventurini.schemino.naive.nodes.LongNode;
import com.albertoventurini.schemino.naive.nodes.OperatorNode;
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
        final var nodes = visitStatements(ctx.statements());
        return new ProgramNode(nodes);
    }

    private List<ExpressionNode> visitStatements(final ScheminoParser.StatementsContext ctx) {
        return ctx.statement().stream().map(statementContext -> {
            if (statementContext.expression() != null) {
                return visitExpression(statementContext.expression());
            } else if (statementContext.assignment() != null) {
                return visitAssignment(statementContext.assignment());
            } else {
                throw new RuntimeException("Invalid state");
            }
        }).collect(Collectors.toList());
    }

    private ExpressionNode visitAssignment(final ScheminoParser.AssignmentContext ctx) {
        final SymbolNode symbolNode = new SymbolNode(ctx.symbol().getText());
        final ExpressionNode expressionNode = visitExpression(ctx.expression());
        return new WriteVariableNode(symbolNode, expressionNode);
    }

    private ExpressionNode visitArrowFunction(final ScheminoParser.ArrowFunctionContext ctx) {
        final boolean tailRec = ctx.tailrec() != null;

        final List<String> parameters = ctx.list().expressions().expression()
                .stream()
                .map(ParseTree::getText)
                .collect(Collectors.toUnmodifiableList());

        final ExpressionNode body = visitExpression(ctx.expression());
        return new LambdaNode(tailRec, parameters, body);
    }

    private ExpressionNode visitExpression(final ScheminoParser.ExpressionContext ctx) {
        if (ctx.functionCall() != null) {
            return visitFunctionCall(ctx.functionCall());
        } else if (ctx.list() != null) {
            return visitList(ctx.list());
        } else if (ctx.atom() != null) {
            return visitAtom(ctx.atom());
        } else if (ctx.block() != null) {
            return visitBlock(ctx.block());
        } else if (ctx.arrowFunction() != null) {
            return visitArrowFunction(ctx.arrowFunction());
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
        } else if (ctx.operator() != null) {
            return visitOperator(ctx.operator());
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

    private ExpressionNode visitOperator(final ScheminoParser.OperatorContext ctx) {
        return new OperatorNode(ctx.getText());
    }

    private ExpressionNode visitBlock(final ScheminoParser.BlockContext ctx) {
        final var nodes = visitStatements(ctx.statements());
        return new BlockNode(nodes);
    }

    private ExpressionNode visitFunctionCall(final ScheminoParser.FunctionCallContext ctx) {
        if (ctx.expression(0).atom() != null
                && ctx.expression(0).atom().keyword() != null
                && ctx.expression(0).atom().keyword().define() != null) {

            // Handle special form 'define'
            return handleDefine(ctx);
        }

        if (ctx.expression(0).atom() != null
                && ctx.expression(0).atom().keyword() != null
                && ctx.expression(0).atom().keyword().lambda() != null) {

            // Handle special form 'lambda'
            return handleLambda(ctx);
        }

        final ExpressionNode functionExpr = visitExpression(ctx.expression().get(0));

        final List<ExpressionNode> argumentExprs = ctx.expression()
                .stream()
                .skip(1)
                .map(this::visitExpression)
                .collect(Collectors.toUnmodifiableList());

        return new FunctionCallNode(functionExpr, argumentExprs);
    }

    private ExpressionNode handleDefine(final ScheminoParser.FunctionCallContext ctx) {
        final SymbolNode symbolNode = new SymbolNode(ctx.expression(1).getText());
        final ExpressionNode expressionNode = visitExpression(ctx.expression(2));
        return new WriteVariableNode(symbolNode, expressionNode);
    }

    private ExpressionNode handleLambda(final ScheminoParser.FunctionCallContext ctx) {
        if (ctx.expression(1).list() == null) {
            throw new RuntimeException("Invalid lambda parameters: " + ctx.expression(1).getText());
        }

        final List<String> parameters = ctx.expression(1).list().expressions().expression()
                .stream()
                .map(ParseTree::getText)
                .collect(Collectors.toUnmodifiableList());

        final ExpressionNode body = visitExpression(ctx.expression(2));
        return new LambdaNode(false, parameters, body);
    }

    private ExpressionNode visitList(final ScheminoParser.ListContext ctx) {
        if (ctx.expressions().expression().isEmpty()) {
            return new ListNode(Collections.emptyList());
        }

        final List<ExpressionNode> items = ctx.expressions().expression()
                .stream()
                .map(this::visitExpression)
                .collect(Collectors.toUnmodifiableList());

        return new ListNode(items);
    }
}
