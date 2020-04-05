package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoException;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

public class ReadVariableNode extends ExpressionNode {

    private final String variableName;

    public ReadVariableNode(final String variableName) {
        this.variableName = variableName;
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        System.out.println("ReadVariableNode:executeGeneric");
        final FrameSlot slot = frame.getFrameDescriptor().findFrameSlot(variableName);

        if (slot == null) {
            throw ScheminoException.variableNotFoundError(this);
        }

        try {
            return frame.getObject(slot);
        } catch (FrameSlotTypeException e) {
            // If we're here, it means we tried to read a variable with the wrong type.
            // E.g. the variable type is long, and we tried reading a generic Object.
            throw ScheminoException.typeError(this);
        }
    }

}
