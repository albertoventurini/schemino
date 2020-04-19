// Generated from com/albertoventurini/schemino/parser/Schemino.g4 by ANTLR 4.8
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
	 * Enter a parse tree produced by {@link ScheminoParser#quote}.
	 * @param ctx the parse tree
	 */
	void enterQuote(ScheminoParser.QuoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#quote}.
	 * @param ctx the parse tree
	 */
	void exitQuote(ScheminoParser.QuoteContext ctx);
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
	 * Enter a parse tree produced by {@link ScheminoParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(ScheminoParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(ScheminoParser.SymbolContext ctx);
}