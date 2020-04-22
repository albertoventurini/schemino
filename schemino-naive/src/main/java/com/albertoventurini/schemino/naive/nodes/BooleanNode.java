package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class BooleanNode extends ExpressionNode {

    private final boolean value;

    public BooleanNode(final boolean value) {

        this.value = value;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        return new TypedObject(ScheminoType.BOOLEAN, value);
    }

    @Override
    public boolean evalBoolean(final Frame frame) {
        return value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
