package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class BlockNode extends ExpressionNode {

    private final List<ExpressionNode> expressions;

    public BlockNode(final List<ExpressionNode> expressions) {
        this.expressions = expressions;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        for (int i = 0; i < expressions.size() - 1; i++) {
            expressions.get(i).eval(frame);
        }

        return expressions.get(expressions.size() - 1).eval(frame);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
