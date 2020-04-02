package com.albertoventurini.schemino.nodes;

import com.albertoventurini.schemino.ScheminoException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

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
