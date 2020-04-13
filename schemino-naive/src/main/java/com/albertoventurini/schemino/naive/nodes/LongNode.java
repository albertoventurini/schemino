package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class LongNode extends ExpressionNode {

    private final long value;

    public LongNode(final long value) {

        this.value = value;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        return new TypedObject(ScheminoType.LONG, value);
    }

    @Override
    public long evalLong(final Frame frame) {
        return value;
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
