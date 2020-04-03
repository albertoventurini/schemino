package com.albertoventurini.schemino.nodes;

import com.albertoventurini.schemino.ScheminoException;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;

@NodeField(name = "variableName", type = String.class)
public abstract class ReadVariableNode extends ExpressionNode {

    // When we annotate a node with @NodeField, we automatically get a getter
    // with the correct name in the generated class.
    // Also, we get a constructor with the appropriate parameters.
    protected abstract String getVariableName();

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        FrameSlot slot = frame.getFrameDescriptor().findFrameSlot(getVariableName());

        try {
            return frame.getObject(slot);
        } catch (FrameSlotTypeException e) {
            // If we're here, it means we tried to read a variable with the wrong type.
            // E.g. the variable type is long, and we tried reading a generic Object.
            throw ScheminoException.typeError(this);
        }
    }

    @Specialization
    public long executeLong(VirtualFrame frame) {
        FrameSlot slot = frame.getFrameDescriptor().findFrameSlot(getVariableName());

        try {
            return frame.getLong(slot);
        } catch (FrameSlotTypeException e) {
            throw ScheminoException.typeError(this);
        }
    }
}
