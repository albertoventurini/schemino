package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.types.ScheminoType;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest extends BaseTest {

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
        final var value = evaluateProgram("(lambda [x y] (+ x y))");
    }

    @Test
    public void lambdaApplication() {
        final var result = evaluateProgram("((lambda [x y] (+ x y)) 1 2)");

        assertEquals(3L, result.getValue());
    }

    @Test
    public void defineFunctionThatReturnsConstant() {
        final var result = evaluateProgram("(define constant (lambda [] 42))\n(constant)");

        assertEquals(42L, result.getValue());
    }

    @Test
    public void definingFunction() {
        final var result = evaluateProgram("(define add (lambda [x y] (+ x y)))\n(add 1 2)");

        assertEquals(3L, result.getValue());
    }

    @Test
    public void passingFunctionsAsValues() {
        final var result = evaluateProgram("(define add +)\n(add 1 2)");

        assertEquals(3L, result.getValue());
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
        final var result = evaluateProgram("(define func (lambda [x] (+ x 1)))\n" +
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
        final var result = evaluateProgram("(define x 0)\n(== x 0 0)");

        assertEquals(ScheminoType.BOOLEAN, result.getType());
        assertTrue((boolean) result.getValue());
    }

    @Test
    public void equals_withDifferentValues_returnFalse() {
        final var result = evaluateProgram("(== 0 1)");

        assertEquals(ScheminoType.BOOLEAN, result.getType());
        assertFalse((boolean) result.getValue());
    }

    @Test
    public void equals_withNoValues_returnTrue() {
        final var result = evaluateProgram("(==)");

        assertEquals(ScheminoType.BOOLEAN, result.getType());
        assertTrue((boolean) result.getValue());
    }

    @Test
    public void equals_withNestedFunctionCalls_works() {
        final var result = evaluateProgram("(== (+ 1 1) (+ 0 2))");

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

        evaluateProgram("[(print 1) (print 2)]");

        assertEquals("1\n2\n", outContent.toString());
    }

    @Test
    public void closures_shouldBeEvaluatedCorrectly() {
        final var result = evaluateProgram(Path.of("src/test/resources/closure.sco"));

        assertEquals(42L, result.getValue());
    }

    @Test
    public void lambda_works() {
        final var result = evaluateProgram("([x] => (+ x 1) 1)");
        assertEquals(2L, result.getValue());
    }

    @Test
    public void lessThan_withCar_works() {
        final var result = evaluateProgram("l: [10 11 12]\n(and (== 0 0) (< 1 (car l)))");

        assertEquals(Boolean.TRUE, result.getValue());
    }

    @Test
    public void blocksHaveIsolatedScopes() {
        final var result = evaluateProgram("{x:1\n{x: 10\nx}\nx}");

        assertEquals(1L, result.getValue());
    }
}
