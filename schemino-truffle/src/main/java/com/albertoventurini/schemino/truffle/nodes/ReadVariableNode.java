package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.exceptions.ScheminoException;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

/**
 * Read a variable from the given frame
 */
public class ReadVariableNode extends ExpressionNode {

    // The symbol associated with this variable
    private final SymbolNode symbolNode;

    public ReadVariableNode(final SymbolNode symbolNode) {
        this.symbolNode = symbolNode;
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        System.out.println("ReadVariableNode:executeGeneric");

        final String symbolName;

        try {
            symbolName = symbolNode.executeString(frame);
        } catch (UnexpectedResultException e) {
            throw new ScheminoException("Unexpected result", symbolNode);
        }

        System.out.println("ReadVariableNode: symbol is " + symbolName);

        final FrameSlot slot = frame.getFrameDescriptor().findFrameSlot(symbolName);

        System.out.println("ReadVariableNode: slot is " + slot);

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

    @Specialization
    @Override
    public long executeLong(final VirtualFrame frame) {
        System.out.println("ReadVariableNode:executeLong");

        final String symbolName;

        try {
            symbolName = symbolNode.executeString(frame);
        } catch (UnexpectedResultException e) {
            throw new ScheminoException("Unexpected result", symbolNode);
        }

        final FrameSlot slot = frame.getFrameDescriptor().findFrameSlot(symbolName);

        if (slot == null) {
            throw ScheminoException.variableNotFoundError(this);
        }

        try {
            return frame.getLong(slot);
        } catch (FrameSlotTypeException e) {
            // If we're here, it means we tried to read a variable with the wrong type.
            // E.g. the variable type is long, and we tried reading a generic Object.
            throw ScheminoException.typeError(this);
        }
    }
}
