package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.exceptions.InvalidFunction;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

/**
 * A node that calls a function.
 *
 * The node wraps a lambda and a list of arguments.
 * First, it applies the arguments to the lambda's parameters.
 * Then, it evaluates the lambda expression.
 */
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
        // `functionNode` should evaluate to a ScheminoFunction object
        final ScheminoFunction function = functionNode.evalFunction(frame);

        if (function == null) {
            throw new InvalidFunction();
        }

        final Frame functionFrame = Frame.fromParent(frame);

        return function.apply(functionFrame, arguments);
    }

}
