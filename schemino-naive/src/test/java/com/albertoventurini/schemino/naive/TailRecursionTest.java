package com.albertoventurini.schemino.naive;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TailRecursionTest extends BaseTest {

    @Test
    public void tailRecursion_shouldWork() throws Exception {
        final String program = Files.readString(Path.of("src/test/resources/tail-recursion.sco"));

        final var result = evaluateProgram(program);

        assertEquals(0L, result.getValue());
    }
}
