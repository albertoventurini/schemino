package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.FrameSlot;
import com.albertoventurini.schemino.naive.exceptions.InvalidFunction;
import com.albertoventurini.schemino.naive.exceptions.UnknownSymbol;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

// A function call node applies arguments to the lambda's parameters,
// then evaluates the lambda's expression

public class FunctionCallNode extends ExpressionNode {

    private ExpressionNode functionNode;
    private final List<ExpressionNode> arguments;

    // 'functionNode' is a ReadVariableNode that should evaluate to a ScheminoFunction
    public FunctionCallNode(
            final ExpressionNode functionNode,
            final List<ExpressionNode> arguments) {
        this.functionNode = functionNode;
        this.arguments = arguments;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        // evaluate the arguments
        // bind the arguments to the lambda's parameters on the frame

        final ScheminoFunction function = functionNode.evalFunction(frame);

        if (function == null) {
            throw new InvalidFunction();
        }

        return function.apply(frame, arguments);
    }


}
