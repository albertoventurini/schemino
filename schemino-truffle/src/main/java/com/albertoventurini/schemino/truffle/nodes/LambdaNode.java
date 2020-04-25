package com.albertoventurini.schemino.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

import java.util.List;

public class LambdaNode extends ExpressionNode {

    private final List<String> parameters;
    private final ExpressionNode body;

    // A lambda node evaluates to a function

    public LambdaNode(final List<String> parameters, final ExpressionNode body) {
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public Object execute(final VirtualFrame frame) {
        return null;
        //return new TypedObject(ScheminoType.FUNCTION, new UserFunction(parameters, body, frame));
    }

//    @Override
//    public ScheminoFunction evalFunction(final Frame frame) {
//        return new UserFunction(parameters, body, frame);
//    }

}
