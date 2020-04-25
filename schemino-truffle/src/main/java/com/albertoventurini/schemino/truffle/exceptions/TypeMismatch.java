package com.albertoventurini.schemino.truffle.exceptions;

import com.albertoventurini.schemino.truffle.types.ScheminoType;
import com.oracle.truffle.api.nodes.Node;

public class TypeMismatch extends ScheminoException {

    public TypeMismatch(final String message, final Node node) {
        super(message, node);
    }

    public TypeMismatch(final ScheminoType expected, final ScheminoType actual, final Node node) {
        super("Expected type " + expected + ", actual type " + actual, node);
    }
}
