package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.exceptions.InvalidFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;
import com.albertoventurini.schemino.parser.ScheminoLexer;
import com.albertoventurini.schemino.parser.ScheminoParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {

    @Test
    public void oneNumber_returnsTheNumber() {
        final var result = evaluateProgram("1");

        assertEquals(1L, result.getValue());
    }

    @Test
    public void variableAssignment() {
        final var result = evaluateProgram("(define x 1)\nx");

        assertEquals(1L, result.getValue());
    }

    @Test
    public void addingTwoNumbers() {
        final var result = evaluateProgram("(+ 1 2)");

        assertEquals(3L, result.getValue());
    }

    @Test
    public void lambdaDefinition() {
        final var value = evaluateProgram("(lambda (x y) (+ x y))");
    }

    @Test
    public void lambdaApplication() {
        final var result = evaluateProgram("((lambda (x y) (+ x y)) 1 2)");

        assertEquals(3L, result.getValue());
    }

    @Test
    public void defineFunctionThatReturnsConstant() {
        final var result = evaluateProgram("(define constant (lambda () 42))\n(constant)");

        assertEquals(42L, result.getValue());
    }

    @Test
    public void definingFunction() {
        final var result = evaluateProgram("(define add (lambda (x y) (+ x y)))\n(add 1 2)");

        assertEquals(3L, result.getValue());
    }

    @Test
    public void passingFunctionsAsValues() {
        final var result = evaluateProgram("(define add +)\n(add 1 2)");

        assertEquals(3L, result.getValue());
    }

    @Test
    public void unknownFunction() {
        assertThrows(InvalidFunction.class, () -> evaluateProgram("(unknown 0 1)"));
    }

    @Test
    public void ifFunction() {
        final var result = evaluateProgram("(if true -1 1)");

        assertEquals(-1L, result.getValue());
    }

    @Test
    public void greaterThanFunction() {
        final var result = evaluateProgram("(> 2 1)");
        assertEquals(ScheminoType.BOOLEAN, result.getType());
        assertTrue((boolean) result.getValue());
    }

    @Test
    public void lexicalScoping() {
        final var result = evaluateProgram("(define func (lambda (x) (+ x 1)))\n" +
                "(define x 1)\n" +
                "(func 2)\n" +
                "x");

        assertEquals(1L, result.getValue());
    }

    @Test
    public void subtractFunction_twoPositiveNumbers_returnsTheCorrectResult() {
        final var result = evaluateProgram("(- 43 1)");

        assertEquals(42L, result.getValue());
    }

    @Test
    public void subtractFunction_noNumbers_returnsZero() {
        final var result = evaluateProgram("(-)");

        assertEquals(0L, result.getValue());
    }

    @Test
    public void subtractFunction_oneNumber_returnsTheNumber() {
        final var result = evaluateProgram("(- 1)");

        assertEquals(1L, result.getValue());
    }

    @Test
    public void equals_withEqualsValues_returnTrue() {
        final var result = evaluateProgram("(define x 0)\n(= x 0 0)");

        assertEquals(ScheminoType.BOOLEAN, result.getType());
        assertTrue((boolean) result.getValue());
    }

    @Test
    public void equals_withDifferentValues_returnFalse() {
        final var result = evaluateProgram("(= 0 1)");

        assertEquals(ScheminoType.BOOLEAN, result.getType());
        assertFalse((boolean) result.getValue());
    }

    @Test
    public void equals_withNoValues_returnTrue() {
        final var result = evaluateProgram("(=)");

        assertEquals(ScheminoType.BOOLEAN, result.getType());
        assertTrue((boolean) result.getValue());
    }

    @Test
    public void equals_withNestedFunctionCalls_works() {
        final var result = evaluateProgram("(= (+ 1 1) (+ 0 2))");

        assertEquals(ScheminoType.BOOLEAN, result.getType());
        assertTrue((boolean) result.getValue());
    }

//    @Test
//    public void cond() {
//        final var result = evaluateProgram("(cond ((= 0 1) 1) ((= 0 0) 2))");
//    }

    private TypedObject evaluateProgram(final String source) {
        final var lexer = new ScheminoLexer(CharStreams.fromString(source));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        final var node = new NodeFactory().createProgramNode(parser);
        return node.run();
    }
}
