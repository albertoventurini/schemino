package com.albertoventurini.schemino.truffle;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleException;
import com.oracle.truffle.api.nodes.Node;

public class ScheminoException extends RuntimeException implements TruffleException {

    private final String message;
    private final Node node;

    @CompilerDirectives.TruffleBoundary
    public ScheminoException(final String message, final Node node) {

        this.message = message;
        this.node = node;
    }

    public static ScheminoException typeError(final Node node) {
        return new ScheminoException("Type error at node " + node, node);
    }

    public static ScheminoException variableNotFoundError(final Node node) {
        return new ScheminoException("Variable not found for node " + node, node);
    }

    @Override
    public Node getLocation() {
        return null;
    }

}
