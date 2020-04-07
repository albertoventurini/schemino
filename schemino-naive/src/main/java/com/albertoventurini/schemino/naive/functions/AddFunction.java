package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class AddFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {
        long sum = 0;

        // TODO: check the argument types and throw if they are not the same.
        // Apply the correct sum for different types (e.g. strings, doubles).

        for (final ExpressionNode argument : arguments) {
            sum += argument.evalLong(frame);
        }

        return new TypedObject(ScheminoType.LONG, sum);
    }

    @Override
    public String toString() {
        return "AddFunction";
    }
}
