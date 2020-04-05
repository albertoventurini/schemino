package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;

public class ReadVariableNode extends ExpressionNode {

    private SymbolNode symbolNode;

    public ReadVariableNode(final SymbolNode symbolNode) {

        this.symbolNode = symbolNode;
    }

    @Override
    public Object eval(final Frame frame) {
        final String name = symbolNode.evalString(frame);

        // TODO: specialize according to the variable type
        return frame.get(name);
    }
}
