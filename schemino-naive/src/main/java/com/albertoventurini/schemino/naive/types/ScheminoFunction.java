package com.albertoventurini.schemino.naive.types;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.nodes.LambdaNode;
import com.albertoventurini.schemino.naive.nodes.SymbolNode;

import java.util.List;

/**
 * The function type.
 */
public class ScheminoFunction {


    protected final List<String> parameters;
    protected final ExpressionNode expression;

    public ScheminoFunction(List<String> parameters, ExpressionNode expression) {

        this.parameters = parameters;
        this.expression = expression;
    }

    public Object apply(Frame frame, List<ExpressionNode> arguments) {
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
