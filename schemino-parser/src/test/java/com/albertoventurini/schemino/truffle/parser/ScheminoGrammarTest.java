//package com.albertoventurini.schemino.truffle.parser;
//
//import com.albertoventurini.schemino.parser.ScheminoLexer;
//import com.albertoventurini.schemino.parser.ScheminoParser;
//import org.antlr.v4.runtime.CharStreams;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ErrorNode;
//import org.antlr.v4.runtime.tree.TerminalNode;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class ScheminoGrammarTest {
//
//    @Test
//    public void parser_withLiteral_shouldParse() {
//        final var lexer = new ScheminoLexer(CharStreams.fromString("1"));
//        final var tokenStream = new CommonTokenStream(lexer);
//        final var parser = new ScheminoParser(tokenStream);
//
//        final var literal = parser.literal();
//        assertEquals("1", literal.getText());
//    }
//
//    @Test
//    public void parser_withList_shouldParse() {
//        final var lexer = new ScheminoLexer(CharStreams.fromString("(+ 1 2)"));
//        final var tokenStream = new CommonTokenStream(lexer);
//        final var parser = new ScheminoParser(tokenStream);
//
//        final var list = parser.list();
//        assertEquals(5, list.children.size());
//        assertEquals("(", list.children.get(0).getText());
//    }
//
//    @Test
//    public void parser_withBadInput_shouldContainErrorNode() {
//        final var lexer = new ScheminoLexer(CharStreams.fromString("(()"));
//        final var tokenStream = new CommonTokenStream(lexer);
//        final var parser = new ScheminoParser(tokenStream);
//
//        final var list = parser.list();
//        assertTrue(list.children.get(2) instanceof ErrorNode);
//    }
//
//    @Test
//    public void parser_withComment_shouldDiscardComment() {
//        final var lexer = new ScheminoLexer(CharStreams.fromString("; comment\n1"));
//        final var tokenStream = new CommonTokenStream(lexer);
//        final var parser = new ScheminoParser(tokenStream);
//
//        final var literal = parser.literal();
//        assertEquals("1", literal.getText());
//    }
//
//    @Test
//    public void parser_multipleLines_shouldParseAllLines() {
//        final var lexer = new ScheminoLexer(CharStreams.fromString("1\n(2)"));
//        final var tokenStream = new CommonTokenStream(lexer);
//        final var parser = new ScheminoParser(tokenStream);
//
//        final var program = parser.program();
//
//        assertEquals(3, program.getChildCount());
//
//        // First child is a literal
//        assertTrue(program.children.get(0) instanceof ScheminoParser.FormContext);
//        assertEquals("1", ((ScheminoParser.FormContext) program.children.get(0)).literal().getText());
//
//        // Second child is a list
//        assertTrue(program.children.get(1) instanceof ScheminoParser.FormContext);
//        final var list = ((ScheminoParser.FormContext) program.children.get(1)).list();
//        assertEquals(3, list.getChildCount());
//        assertEquals("2", list.getChild(1).getText());
//
//        // Third child is EOF
//        assertTrue(program.children.get(2) instanceof TerminalNode);
//    }
//}
