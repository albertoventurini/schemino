package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class SubtractFunction implements ScheminoFunction {
    @Override
    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {
        if (arguments.isEmpty()) {
            return new TypedObject(ScheminoType.LONG, 0L);
        }

        long result = arguments.get(0).evalLong(frame);

        // TODO: check the argument types and throw if they are not the same.

        for (int i = 1; i < arguments.size(); i++) {
            result -= arguments.get(i).evalLong(frame);
        }

        return new TypedObject(ScheminoType.LONG, result);
    }

    @Override
    public String toString() {
        return "SubtractFunction";
    }
}
