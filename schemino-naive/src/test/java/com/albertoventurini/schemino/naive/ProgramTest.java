package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.exceptions.UnknownSymbol;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;
import com.albertoventurini.schemino.parser.ScheminoLexer;
import com.albertoventurini.schemino.parser.ScheminoParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        assertThrows(UnknownSymbol.class, () -> evaluateProgram("(unknown 0 1)"));
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
//    public void list_isEvaluatedAsAList() {
//        final var result = evaluateProgram("(1 2 3)");
//        assertEquals(ScheminoType.LIST, result.getType());
//        assertTrue(result.getValue() instanceof ScheminoList);
//        final ScheminoList list = (ScheminoList) result.getValue();
//        assertEquals(3, list.getItems().size());
//        assertEquals(1L, list.getItems().get(0).getValue());
//    }

    @Test
    public void quote_shouldReturnQuotedList() {
        final var result = evaluateProgram("(quote (+ 1 2 3))");
        assertEquals(ScheminoType.LIST, result.getType());
        assertTrue(result.getValue() instanceof ScheminoList);
        final ScheminoList list = (ScheminoList) result.getValue();
        assertEquals(4, list.getItems().size());
        assertTrue(list.getItems().get(0).getValue() instanceof ScheminoFunction);
    }

    @Test
    public void emptyString_shouldReturnString() {
        final var result = evaluateProgram("\"\"");
        assertEquals(ScheminoType.STRING, result.getType());
        assertEquals("", result.getValue());
    }


    @Test
    public void string_shouldReturnString() {
        final var result = evaluateProgram("\"hello\"");
        assertEquals(ScheminoType.STRING, result.getType());
        assertEquals("hello", result.getValue());
    }

    @Test
    public void programWithMultipleExpressions_shouldReturnValueOfLastExpression() {
        final var result = evaluateProgram("(print 1)\n(print 2)\n2");
        assertEquals(2L, result.getValue());
    }

    @Test
    public void firstItemOfListIsOnlyEvaluatedOnce() {
        var outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        evaluateProgram("((print 1) (print 2))");

        assertEquals("1\n2\n", outContent.toString());
    }

    private TypedObject evaluateProgram(final String source) {
        final var lexer = new ScheminoLexer(CharStreams.fromString(source));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        final var node = new NodeFactory().createProgramNode(parser);
        return node.run();
    }
}
