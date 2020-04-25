package com.albertoventurini.schemino.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

public class SymbolNode extends ExpressionNode {

    private final String symbolName;

    public SymbolNode(final String symbolName) {
        this.symbolName = symbolName;
    }

    @Override
    public Object execute(final VirtualFrame frame) {
        return symbolName;
    }
//
//    @Override
//    public String executeString(final VirtualFrame frame) {
//        return symbolName;
//    }

    @Override
    public String toString() {
        return symbolName;
    }
}
