package com.albertoventurini.schemino.naive.types;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;

import java.util.List;

/**
 * Generic interface for Schemino functions.
 */
public interface ScheminoFunction {
    /**
     * Apply the arguments to the function parameters, then
     * execute the function body and return its result.
     *
     * @param frame the invoker frame
     * @param arguments the arguments to be passed to the function
     * @return the result of executing the function
     */
    TypedObject apply(Frame frame, List<ExpressionNode> arguments);
}
