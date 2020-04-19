package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

/**
 * Represents a user-defined (i.e., not built-in) function.
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
    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {
        assert(arguments.size() == parameters.size());

        for (int i = 0; i < arguments.size(); i++) {
            frame.putObject(parameters.get(i), arguments.get(i).eval(frame));
        }

        return expression.eval(frame);
    }

    @Override
    public String toString() {
        return "UserFunction{" +
                "parameters=" + parameters +
                ", expression=" + expression +
                '}';
    }
}
