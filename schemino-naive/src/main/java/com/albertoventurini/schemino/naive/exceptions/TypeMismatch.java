package com.albertoventurini.schemino.naive.exceptions;

import com.albertoventurini.schemino.naive.types.ScheminoType;

public class TypeMismatch extends ScheminoException {

    public TypeMismatch(final String message) {
        super(message);
    }

    public TypeMismatch(final ScheminoType expected, final ScheminoType actual) {
        super("Expected type " + expected + ", actual type " + actual);
    }
}
