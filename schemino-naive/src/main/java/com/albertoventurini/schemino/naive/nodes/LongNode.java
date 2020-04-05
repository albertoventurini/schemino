package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;

public class LongNode extends ExpressionNode {

    private long value;

    public LongNode(final long value) {

        this.value = value;
    }

    @Override
    public Object eval(Frame frame) {
        return value;
    }

    @Override
    public long evalLong(final Frame frame) {
        return value;
    }
}
