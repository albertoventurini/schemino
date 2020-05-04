package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class OperatorNode extends ExpressionNode {

    private final String operator;

    public OperatorNode(final String operator) {

        this.operator = operator;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        return frame.getObject(operator);
    }

    @Override
    public ScheminoFunction evalFunction(final Frame frame) {
        return frame.getFunction(operator);
    }

    @Override
    public String toString() {
        return operator;
    }
}
