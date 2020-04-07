package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.FrameSlot;
import com.albertoventurini.schemino.naive.exceptions.InvalidFunction;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class ReadVariableNode extends ExpressionNode {

    private SymbolNode symbolNode;

    public ReadVariableNode(final SymbolNode symbolNode) {
        this.symbolNode = symbolNode;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        final String name = symbolNode.evalString(frame);
        final FrameSlot slot = frame.getSlot(name);

        return new TypedObject(slot.getType(), slot.getValue());
    }

    @Override
    public long evalLong(final Frame frame) {
        final String name = symbolNode.evalString(frame);
        return frame.getLong(name);
    }

    @Override
    public ScheminoFunction evalFunction(final Frame frame) {
        final String name = symbolNode.evalString(frame);

        if (!frame.hasSlot(name)) {
            throw new InvalidFunction(name);
        }

        return frame.getFunction(name);
    }
}
