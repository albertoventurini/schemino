package com.albertoventurini.schemino;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.TruffleException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.source.SourceSection;

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

    @Override
    public Node getLocation() {
        return null;
    }

    @Override
    public Object getExceptionObject() {
        return null;
    }

    @Override
    public boolean isSyntaxError() {
        return false;
    }

    @Override
    public boolean isIncompleteSource() {
        return false;
    }

    @Override
    public boolean isInternalError() {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public int getExitStatus() {
        return 0;
    }

    @Override
    public int getStackTraceElementLimit() {
        return 0;
    }

    @Override
    public SourceSection getSourceLocation() {
        return null;
    }
}
