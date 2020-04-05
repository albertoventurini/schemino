package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;

import java.util.List;

public class LambdaNode extends ExpressionNode {
    private ScheminoFunction function;

    // A lambda has a list of parameters and a body (expression)

//    private final List<SymbolNode> parameters;
//    private final ExpressionNode expression;
//
//    public LambdaNode(List<SymbolNode> parameters, ExpressionNode expression) {
//
//        this.parameters = parameters;
//        this.expression = expression;
//    }
//
//    @Override
//    public Object eval(Frame frame) {
//        return null;
//    }


    // A lambda node evaluates to a function

    public LambdaNode(List<String> parameters, ExpressionNode expressionNode) {
        this.function = new ScheminoFunction(parameters, expressionNode);
    }

    @Override
    public Object eval(Frame frame) {
        return function;
    }
}
