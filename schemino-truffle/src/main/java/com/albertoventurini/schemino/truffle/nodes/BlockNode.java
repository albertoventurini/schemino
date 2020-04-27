package com.albertoventurini.schemino.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

public class BlockNode extends ExpressionNode {

    @Children private ExpressionNode[] expressions;

    public BlockNode(final ExpressionNode[] expressions) {
        this.expressions = expressions;
    }

    @Override
    @ExplodeLoop
    public Object execute(final VirtualFrame frame) {
        System.out.println("BlockNode:executeGeneric");

        if (expressions.length == 0) {
            return null;
        }

        for (int i = 0; i < expressions.length - 1; i++) {
            expressions[i].execute(frame);
        }

        return expressions[expressions.length - 1].execute(frame);
    }
}
