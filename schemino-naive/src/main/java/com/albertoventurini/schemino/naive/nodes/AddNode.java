package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;

import java.util.List;

public class AddNode extends ExpressionNode {

    private List<Long> values;

    public AddNode(List<Long> values) {
        this.values = values;

    }

    @Override
    public Object eval(Frame frame) {
        return values.stream().reduce(Long::sum).get();
    }
}
