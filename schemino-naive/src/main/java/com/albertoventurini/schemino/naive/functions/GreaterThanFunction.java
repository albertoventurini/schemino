package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class GreaterThanFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {
        if (arguments.size() != 2) {
            throw new InvalidArgumentNumber(3, arguments.size());
        }

        // TODO: check the argument types and throw if they are not the same.
        // Apply the correct comparison for different types (e.g. strings, doubles).

        final long left = arguments.get(0).evalLong(frame);
        final long right = arguments.get(1).evalLong(frame);

        return new TypedObject(ScheminoType.BOOLEAN, left > right);
    }

    @Override
    public String toString() {
        return "GreaterThanFunction";
    }
}

