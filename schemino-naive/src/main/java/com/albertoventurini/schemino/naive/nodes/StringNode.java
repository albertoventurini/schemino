package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class StringNode extends ExpressionNode {

    private final String value;

    public StringNode(final String value) {
        this.value = value;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        return new TypedObject(ScheminoType.STRING, value);
    }

    @Override
    public String evalString(final Frame frame) {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
