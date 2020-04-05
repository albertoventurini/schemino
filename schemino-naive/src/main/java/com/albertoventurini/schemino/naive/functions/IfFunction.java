package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;

import java.util.List;

public class IfFunction implements ScheminoFunction {

    @Override
    public Object apply(final Frame frame, final List<ExpressionNode> arguments) {
        if (arguments.size() != 3) {
            throw new InvalidArgumentNumber(3, arguments.size());
        }

        if ((boolean) arguments.get(0).eval(frame)) {
            return arguments.get(1).eval(frame);
        } else {
            return arguments.get(2).eval(frame);
        }
    }
}
