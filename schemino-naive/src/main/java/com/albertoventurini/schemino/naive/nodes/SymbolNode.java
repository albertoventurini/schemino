package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class SymbolNode extends ExpressionNode {

    private String symbolName;

    public SymbolNode(final String symbolName) {

        this.symbolName = symbolName;
    }

    @Override
    public TypedObject eval(Frame frame) {
        return new TypedObject(ScheminoType.STRING, symbolName);
    }

    @Override
    public String evalString(Frame frame) {
        return symbolName;
    }
}
