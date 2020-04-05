package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;

public class AddNode extends ExpressionNode {

    private long[] values;

    public AddNode(long[] values) {

        this.values = values;
    }

    @Override
    public long evalLong(Frame frame) {
        long sum = 0;
        for (long value : values) {
            sum += value;
        }
        return sum;
    }
}
