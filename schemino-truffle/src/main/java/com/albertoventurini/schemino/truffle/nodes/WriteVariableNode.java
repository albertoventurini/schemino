package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.exceptions.ScheminoException;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class WriteVariableNode extends ExpressionNode {

    /**
     * The symbol that identifies the variable.
     */
    private final SymbolNode symbolNode;

    /**
     * The expression that evaluates to the value of the variable.
     */
    private final ExpressionNode expressionNode;

    public WriteVariableNode(
            final SymbolNode symbolNode,
            final ExpressionNode expressionNode) {
        this.symbolNode = symbolNode;
        this.expressionNode = expressionNode;
    }

    @Override
    public Object execute(final VirtualFrame frame) {
        System.out.println("WriteVariableNode:executeGeneric");
        System.out.println(frame);

        final String symbolName;

        try {
            symbolName = symbolNode.executeString(frame);
        } catch (UnexpectedResultException e) {
            throw new ScheminoException("Unexpected result", symbolNode);
        }

        final Object value = expressionNode.execute(frame);

        final FrameSlot slot = frame.getFrameDescriptor().addFrameSlot(symbolName, FrameSlotKind.Object);
        frame.setObject(slot, value);
        return value;
    }
}
