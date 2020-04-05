package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;

public class BooleanNode extends ExpressionNode {

    private boolean value;

    public BooleanNode(final boolean value) {

        this.value = value;
    }

    @Override
    public Object eval(Frame frame) {
        return value;
    }
}
