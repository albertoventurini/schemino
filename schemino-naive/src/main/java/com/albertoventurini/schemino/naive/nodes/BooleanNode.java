package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class BooleanNode extends ExpressionNode {

    private boolean value;

    public BooleanNode(final boolean value) {

        this.value = value;
    }

    @Override
    public TypedObject eval(Frame frame) {
        return new TypedObject(ScheminoType.BOOLEAN, value);
    }

    @Override
    public boolean evalBoolean(Frame frame) {
        return value;
    }
}
