package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;

import java.util.List;

// A function call node applies arguments to the lambda's parameters,
// then evaluates the lambda's expression

public class FunctionCallNode extends ExpressionNode {

    private ExpressionNode functionNode;
    private final List<ExpressionNode> arguments;

    // 'functionNode' is a node that should evaluate to a ScheminoFunction
    public FunctionCallNode(ExpressionNode functionNode, List<ExpressionNode> arguments) {
        this.functionNode = functionNode;

        this.arguments = arguments;
    }

    @Override
    public Object eval(Frame frame) {
        // evaluate the arguments
        // bind the arguments to the lambda's parameters on the frame
        // eval the lambda? call the lambda?

        ScheminoFunction function = (ScheminoFunction) functionNode.eval(frame);

        return function.apply(frame, arguments);
    }
}
