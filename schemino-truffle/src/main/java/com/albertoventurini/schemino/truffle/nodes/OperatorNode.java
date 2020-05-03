package com.albertoventurini.schemino.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class OperatorNode extends ExpressionNode {

    private final String operator;

    public OperatorNode(final String operator) {

        this.operator = operator;
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
//        return frame.getObject(operator);
        return null;
    }

//    @Override
//    public ScheminoFunction evalFunction(final Frame frame) {
//        return frame.getFunction(operator);
//    }
}
