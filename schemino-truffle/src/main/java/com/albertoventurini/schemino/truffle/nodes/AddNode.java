package com.albertoventurini.schemino.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class AddNode extends ExpressionNode {

    @Children private ExpressionNode[] expressions;

    public AddNode(ExpressionNode[] expressions) {
        this.expressions = expressions;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return null;
    }
}
