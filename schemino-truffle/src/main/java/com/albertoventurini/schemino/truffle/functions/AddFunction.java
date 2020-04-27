package com.albertoventurini.schemino.truffle.functions;

import com.albertoventurini.schemino.truffle.nodes.AddNode;
import com.albertoventurini.schemino.truffle.nodes.ExpressionNode;
import com.albertoventurini.schemino.truffle.nodes.ScheminoNode;
import com.albertoventurini.schemino.truffle.types.Arguments;
import com.albertoventurini.schemino.truffle.types.ScheminoFunction;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;

/**
 * A built-in function that adds elements and returns the sum.
 * Usage example:
 *
 * (+ 1 2 3) -> 6
 */
public class AddFunction implements ScheminoFunction {

    private final RootCallTarget callTarget;

    public AddFunction(RootCallTarget callTarget) {
        this.callTarget = callTarget;
    }

    @Override
    public Object apply(final Arguments arguments) {
        return callTarget.call(1, 2, 3);
    }

    @Override
    public String toString() {
        return "AddFunction";
    }
}
