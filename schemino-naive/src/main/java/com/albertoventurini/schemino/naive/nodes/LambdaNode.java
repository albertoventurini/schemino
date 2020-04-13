package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.functions.UserFunction;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class LambdaNode extends ExpressionNode {
    private final UserFunction function;

    // A lambda node evaluates to a function

    public LambdaNode(final List<String> parameters, final ExpressionNode expressionNode) {
        this.function = new UserFunction(parameters, expressionNode);
    }

    @Override
    public TypedObject eval(final Frame frame) {
        return new TypedObject(ScheminoType.FUNCTION, function);
    }

    @Override
    public ScheminoFunction evalFunction(final Frame frame) {
        return function;
    }

}
