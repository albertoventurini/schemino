package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.types.ScheminoType;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest extends BaseTest {

    @Test
    public void insertionSort_works() {
        final var result = evaluateProgram(Path.of("src/test/resources/insertion-sort.sco"));

        assertEquals(ScheminoType.LIST, result.getType());
        final var list = result.getListOrThrow();
        assertEquals(1L, list.get(0).getValue());
        assertEquals(2L, list.get(1).getValue());
        assertEquals(42L, list.get(list.size() - 1).getValue());
    }
}
