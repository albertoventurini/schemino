package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class SymbolNode extends ExpressionNode {

    private final String symbolName;

    public SymbolNode(final String symbolName) {
        this.symbolName = symbolName;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        return new TypedObject(ScheminoType.STRING, symbolName);
    }

    @Override
    public String evalString(final Frame frame) {
        return symbolName;
    }

    @Override
    public String toString() {
        return symbolName;
    }
}
