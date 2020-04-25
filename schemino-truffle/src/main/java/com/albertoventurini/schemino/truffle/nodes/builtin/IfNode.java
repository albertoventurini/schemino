package com.albertoventurini.schemino.truffle.nodes.builtin;

import com.albertoventurini.schemino.truffle.nodes.ExpressionNode;
import com.albertoventurini.schemino.truffle.types.Arguments;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class IfNode extends BuiltinNode {

    @Override
    public Object execute(final VirtualFrame frame) {
        final Arguments arguments = getArguments(frame);

        try {
            if (arguments.getBoolean(0)) {
                return arguments.get(1);
            } else {
                return arguments.get(2);
            }
        } catch (UnexpectedResultException e) {
            throw new RuntimeException(e);
        }
    }
}
