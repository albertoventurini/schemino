package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.FrameSlot;
import com.albertoventurini.schemino.naive.exceptions.InvalidFunction;
import com.albertoventurini.schemino.naive.exceptions.UnknownSymbol;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

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
    public TypedObject eval(final Frame frame) {
        final String symbolName = symbolNode.evalString(frame);
        final FrameSlot slot = frame.getSlot(symbolName);

        if (slot == null) {
            throw new UnknownSymbol(symbolName);
        }

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

    @Override
    public String toString() {
        return symbolNode.toString();
    }
}
