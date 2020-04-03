package com.albertoventurini.schemino.nodes;

import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;

public class WriteVariableNode extends ExpressionNode {

    private final String variableName;
    private final Object value;

    public WriteVariableNode(final String variableName, final Object value) {

        this.variableName = variableName;
        this.value = value;
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        System.out.println("WriteVariableNode:executeGeneric");
        System.out.println(frame);
        final FrameSlot slot = frame.getFrameDescriptor().addFrameSlot(variableName, FrameSlotKind.Object);
        frame.setObject(slot, value);
        return value;
    }

}
