package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;

import java.util.List;

public class ProgramNode extends ExpressionNode {

    private List<ExpressionNode> expressions;

    public ProgramNode(final List<ExpressionNode> expressions) {
        this.expressions = expressions;
    }

    public Object run() {
        final Frame frame = new Frame();
        return eval(frame);
    }

    @Override
    public Object eval(final Frame frame) {
        for (int i = 0; i < expressions.size() - 1; i++) {
            expressions.get(i).eval(frame);
        }

        return expressions.get(expressions.size() - 1).eval(frame);
    }
}
