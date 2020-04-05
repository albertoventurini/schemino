package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;

import java.util.List;

public class AddFunction implements ScheminoFunction {

    @Override
    public Object apply(final Frame frame, final List<ExpressionNode> arguments) {
        long sum = 0;

        for (final ExpressionNode argument : arguments) {
            sum += (long) argument.eval(frame);
        }

        return sum;
    }
}
