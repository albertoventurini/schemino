package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;

import java.util.List;

/**
 * The function type.
 */
public class UserFunction implements ScheminoFunction {


    protected final List<String> parameters;
    protected final ExpressionNode expression;

    public UserFunction(
            final List<String> parameters,
            final ExpressionNode expression) {
        this.parameters = parameters;
        this.expression = expression;
    }

    @Override
    public Object apply(final Frame frame, final List<ExpressionNode> arguments) {
        assert(arguments.size() == parameters.size());

        for (int i = 0; i < arguments.size(); i++) {
            frame.put(parameters.get(i), arguments.get(i).eval(frame));
        }

        return expression.eval(frame);
    }

    @Override
    public String toString() {
        return "ScheminoFunction{" +
                "parameters=" + parameters +
                ", expression=" + expression +
                '}';
    }
}
