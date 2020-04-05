package com.albertoventurini.schemino.naive.exceptions;

public class InvalidArgumentNumber extends ScheminoException {

    public InvalidArgumentNumber(final int expected, final int actual) {
        super("Invalid number of arguments: got " + actual + " arguments, expected " + expected);
    }
}
