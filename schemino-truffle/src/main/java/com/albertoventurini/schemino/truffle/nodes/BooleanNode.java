package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.exceptions.ScheminoException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class BooleanNode extends ExpressionNode {

    private final boolean value;

    public BooleanNode(final boolean value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        throw ScheminoException.typeError(this);
    }

    @Override
    public boolean executeBoolean(final VirtualFrame frame) {
        return value;
    }
}
