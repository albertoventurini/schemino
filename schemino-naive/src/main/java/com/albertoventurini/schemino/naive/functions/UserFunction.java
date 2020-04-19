package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a user-defined (i.e., not built-in) function.
 */
public class UserFunction implements ScheminoFunction {

    /**
     * The parameters to this function
     */
    protected final List<String> parameters;

    /**
     * The body of this function
     */
    protected final ExpressionNode body;

    public UserFunction(
            final List<String> parameters,
            final ExpressionNode body) {
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {
        assert(arguments.size() == parameters.size());

        // A map to temporarily store the evaluated arguments. We first put those in
        // an intermediate map, because if we put them straight on the frame,
        // other objects might not be initialised properly.
        // E.g. if there is an argument that reassigns a variable (e.g. x = x + 1)
        // and another argument that uses the first (e.g. y = x), we need to ensure that
        // y is given the original value of x, not the new value.
        final Map<String, TypedObject> evaluatedArguments = new HashMap<>();

        for (int i = 0; i < arguments.size(); i++) {
            evaluatedArguments.put(parameters.get(i), arguments.get(i).eval(frame));
        }

        // Once we have evaluated all arguments, we put them into the function frame.
        evaluatedArguments.forEach(frame::putObject);

        return body.eval(frame);
    }

    @Override
    public String toString() {
        return "UserFunction{" +
                "parameters=" + parameters +
                ", expression=" + body +
                '}';
    }
}
