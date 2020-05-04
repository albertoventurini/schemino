package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.functions.UserFunction;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class LambdaNode extends ExpressionNode {

    private final List<String> parameters;
    private final ExpressionNode body;
    private final boolean tailRec;

    // A lambda node evaluates to a function

    public LambdaNode(
            final boolean tailRec,
            final List<String> parameters,
            final ExpressionNode body) {
        this.tailRec = tailRec;
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        return new TypedObject(ScheminoType.FUNCTION, new UserFunction(parameters, body, frame, tailRec));
    }

    @Override
    public ScheminoFunction evalFunction(final Frame frame) {
        return new UserFunction(parameters, body, frame, tailRec);
    }

}
