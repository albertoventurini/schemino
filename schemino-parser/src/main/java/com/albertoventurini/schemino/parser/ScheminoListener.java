// Generated from com/albertoventurini/schemino/parser/Schemino.g4 by ANTLR 4.7.1
package com.albertoventurini.schemino.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScheminoParser}.
 */
public interface ScheminoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ScheminoParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ScheminoParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(ScheminoParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(ScheminoParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ScheminoParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ScheminoParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(ScheminoParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(ScheminoParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ScheminoParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ScheminoParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ScheminoParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ScheminoParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#arrowFunction}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunction(ScheminoParser.ArrowFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#arrowFunction}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunction(ScheminoParser.ArrowFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#tailrec}.
	 * @param ctx the parse tree
	 */
	void enterTailrec(ScheminoParser.TailrecContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#tailrec}.
	 * @param ctx the parse tree
	 */
	void exitTailrec(ScheminoParser.TailrecContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(ScheminoParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(ScheminoParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(ScheminoParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(ScheminoParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ScheminoParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ScheminoParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ScheminoParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ScheminoParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(ScheminoParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(ScheminoParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ScheminoParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ScheminoParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ScheminoParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ScheminoParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(ScheminoParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(ScheminoParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(ScheminoParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(ScheminoParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(ScheminoParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(ScheminoParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(ScheminoParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(ScheminoParser.SymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScheminoParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(ScheminoParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(ScheminoParser.OperatorContext ctx);
}