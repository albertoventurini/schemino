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
        final var value = evaluateProgram("1");

        assertEquals(1L, value);
    }

    @Test
    public void variableAssignment() {
        final var value = evaluateProgram("(define x 1)\nx");

        assertEquals(1L, value);
    }

    @Test
    public void addingTwoNumbers() {
        final var value = evaluateProgram("(+ 1 2)");

        assertEquals(3L, value);
    }

    @Test
    public void lambdaDefinition() {
        final var value = evaluateProgram("(lambda (x y) (+ x y))");
    }

    @Test
    public void lambdaApplication() {
        final var value = evaluateProgram("((lambda (x y) (+ x y)) 1 2)");

        assertEquals(3L, value);
    }

    @Test
    public void defineFunctionThatReturnsConstant() {
        final var value = evaluateProgram("(define constant (lambda () 42))\n(constant)");

        assertEquals(42L, value);
    }

    @Test
    public void definingFunction() {
        final var value = evaluateProgram("(define add (lambda (x y) (+ x y)))\n(add 1 2)");

        assertEquals(3L, value);
    }

    @Test
    public void passingFunctionsAsValues() {
        final var value = evaluateProgram("(define add +)\n(add 1 2)");

        assertEquals(3L, value);
    }

    private Object evaluateProgram(final String source) {
        final var lexer = new ScheminoLexer(CharStreams.fromString(source));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        final var node = new NodeFactory().createProgramNode(parser);
        return node.run();
    }
}
