package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;

public class SymbolNode extends ExpressionNode {

    private String symbolName;

    public SymbolNode(final String symbolName) {

        this.symbolName = symbolName;
    }

    @Override
    public Object eval(Frame frame) {
        return symbolName;
    }

    @Override
    public String evalString(Frame frame) {
        return symbolName;
    }
}
