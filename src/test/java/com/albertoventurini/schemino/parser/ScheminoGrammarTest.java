package com.albertoventurini.schemino.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScheminoGrammarTest {

    @Test
    public void parser_withWellFormedInput_shouldParse() {
        final var lexer = new ScheminoLexer(CharStreams.fromString("(+ 1 2)"));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        var l = parser.list();
        assertEquals(5, l.children.size());
        assertEquals("(", l.children.get(0).getText());
        int i = 0;
    }

    @Test
    public void parser_withBadInput_shouldContainErrorNode() {
        final var lexer = new ScheminoLexer(CharStreams.fromString("(()"));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        var l = parser.list();
        assertTrue(l.children.get(2) instanceof ErrorNode);
    }
}
