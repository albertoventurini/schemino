package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;

public class WriteVariableNode extends ExpressionNode {

    private final SymbolNode symbolNode;
    private final ExpressionNode expression;

    public WriteVariableNode(
            final SymbolNode symbolNode,
            final ExpressionNode expressionNode) {

        this.symbolNode = symbolNode;
        this.expression = expressionNode;
    }

    @Override
    public Object eval(Frame frame) {
        String name = symbolNode.evalString(frame);
        Object value = expression.eval(frame);

        frame.put(name, value);

        return value;
    }
}
