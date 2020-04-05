package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.parser.ScheminoLexer;
import com.albertoventurini.schemino.parser.ScheminoParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest {

    @Test
    public void oneNumber_returnsTheNumber() {
        final var lexer = new ScheminoLexer(CharStreams.fromString("1"));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        final var node = new NodeFactory().createProgramNode(parser);
        final var value = node.run();

        assertEquals(1L, value);
    }

    @Test
    public void variableAssignment() {
        final var lexer = new ScheminoLexer(CharStreams.fromString("(define x 1)\nx"));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        final var node = new NodeFactory().createProgramNode(parser);
        final var value = node.run();

        assertEquals(1L, value);
    }
}
