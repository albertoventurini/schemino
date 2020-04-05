package com.albertoventurini.schemino.naive.types;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;

import java.util.List;

public class AddFunction extends ScheminoFunction {

    public AddFunction() {
        super(null, null);
    }

    @Override
    public Object apply(Frame frame, List<ExpressionNode> arguments) {
        long sum = 0;

        for (int i = 0; i < arguments.size(); i++) {
            sum += (long) arguments.get(i).eval(frame);
            //frame.put(parameters.get(i), arguments.get(i).eval(frame));
        }

//        return expression.eval(frame);

        return sum;
    }
}
