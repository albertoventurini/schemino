package com.albertoventurini.schemino.truffle.nodes.builtin;

import com.albertoventurini.schemino.truffle.nodes.ExpressionNode;
import com.albertoventurini.schemino.truffle.types.Arguments;
import com.oracle.truffle.api.frame.VirtualFrame;

public abstract class BuiltinNode extends ExpressionNode {

    protected Arguments getArguments(final VirtualFrame frame) {
        return (Arguments) ((Object[]) frame.getArguments()[1])[0];
    }
}
