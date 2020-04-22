package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.types.ScheminoType;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for list-related functions
 */
public class ListTest extends BaseTest {

    @Test
    public void car_returnsFirstElementOfList() {
        final var result = evaluateProgram("(car (1 2 3))");

        assertEquals(1L, result.getValue());
    }

    @Test
    public void cdr_returnsRestOfList() {
        final var result = evaluateProgram("(cdr (1 2 3))");

        assertEquals(ScheminoType.LIST, result.getType());
        assertEquals(2L, result.getListOrThrow().get(0).getLongOrThrow());
        assertEquals(3L, result.getListOrThrow().get(1).getLongOrThrow());
    }

    @Test
    public void append_appendsLists() {
        final var result = evaluateProgram("(append (1) () (2 3) ())");

        assertEquals(ScheminoType.LIST, result.getType());
        assertEquals(1L, result.getListOrThrow().get(0).getLongOrThrow());
        assertEquals(2L, result.getListOrThrow().get(1).getLongOrThrow());
        assertEquals(3L, result.getListOrThrow().get(2).getLongOrThrow());
    }

//    @Test
//    public void foldLeft_foldsLists() {
//        final var result = evaluateProgram("(fold-left + 0 (1 2 3 4 5))");
//
//        assertEquals(15L, result.getValue());
//    }
}
