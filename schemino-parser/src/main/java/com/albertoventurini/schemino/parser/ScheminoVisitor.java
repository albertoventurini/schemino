// Generated from com/albertoventurini/schemino/parser/Schemino.g4 by ANTLR 4.8
package com.albertoventurini.schemino.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScheminoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ScheminoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ScheminoParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(ScheminoParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ScheminoParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(ScheminoParser.ExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ScheminoParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ScheminoParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#arrowFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunction(ScheminoParser.ArrowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#quote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote(ScheminoParser.QuoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(ScheminoParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ScheminoParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ScheminoParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(ScheminoParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ScheminoParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ScheminoParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(ScheminoParser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(ScheminoParser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(ScheminoParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(ScheminoParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScheminoParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(ScheminoParser.OperatorContext ctx);
}