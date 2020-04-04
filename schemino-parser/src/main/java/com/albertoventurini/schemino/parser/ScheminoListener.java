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
	 * Enter a parse tree produced by {@link ScheminoParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(ScheminoParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(ScheminoParser.FormContext ctx);
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
	 * Enter a parse tree produced by {@link ScheminoParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ScheminoParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheminoParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ScheminoParser.LiteralContext ctx);
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