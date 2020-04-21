package com.albertoventurini.schemino.naive;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest extends BaseTest {

    @Test
    public void fibonacciNaive_shouldWork() throws Exception {
        final String program = Files.readString(Path.of("src/test/resources/fibonacci.sco"));

        final var result = evaluateProgram(program);

        assertEquals(89L, result.getValue());
    }

    @Test
    public void fibonacciLinear_shouldWork() throws Exception {
        final String program = Files.readString(Path.of("src/test/resources/fibonacci-linear.sco"));

        final var result = evaluateProgram(program);

        assertEquals(89L, result.getValue());
    }
}
