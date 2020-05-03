package com.albertoventurini.schemino.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class StringNode extends ExpressionNode {

    private final String value;

    public StringNode(final String value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public String executeString(VirtualFrame frame) throws UnexpectedResultException {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
