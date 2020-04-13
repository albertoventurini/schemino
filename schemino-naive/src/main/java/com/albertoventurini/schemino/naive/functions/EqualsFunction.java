package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class EqualsFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {
        if (arguments.isEmpty()) {
            return new TypedObject(ScheminoType.BOOLEAN, true);
        }

        final boolean allEquals = arguments
                .stream()
                .map(a -> a.evalLong(frame))
                .distinct()
                .count() == 1;

        return new TypedObject(ScheminoType.BOOLEAN, allEquals);
    }

    @Override
    public String toString() {
        return "EqualsFunction";
    }
}
