package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.FrameSlot;
import com.albertoventurini.schemino.naive.exceptions.InvalidFunction;
import com.albertoventurini.schemino.naive.exceptions.UnknownSymbol;
import com.albertoventurini.schemino.naive.types.ScheminoDictionary;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
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
    public double evalDouble(final Frame frame) {
        throw new RuntimeException("Unimplemented");
    }

    @Override
    public boolean evalBoolean(final Frame frame) {
        final String name = symbolNode.evalString(frame);
        return frame.getBoolean(name);
    }

    @Override
    public String evalString(final Frame frame) {
        throw new RuntimeException("Unimplemented");
    }

    @Override
    public ScheminoDictionary evalDictionary(final Frame frame) {
        throw new RuntimeException("Unimplemented");
    }

    @Override
    public ScheminoList evalList(final Frame frame) {
        final String name = symbolNode.evalString(frame);
        return frame.getList(name);
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
