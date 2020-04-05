package com.albertoventurini.schemino.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class BlockNode extends ExpressionNode {

    @Children private ExpressionNode[] children;

    public BlockNode(final ExpressionNode[] children) {
        this.children = children;
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        System.out.println("BlockNode:executeGeneric");

        if (children.length == 0) {
            return null;
        }

        for (int i = 0; i < children.length - 1; i++) {
            children[i].executeGeneric(frame);
        }

        return children[children.length - 1].executeGeneric(frame);
    }
}
