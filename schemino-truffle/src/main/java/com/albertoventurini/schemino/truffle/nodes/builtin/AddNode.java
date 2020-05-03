package com.albertoventurini.schemino.truffle.nodes.builtin;

import com.albertoventurini.schemino.truffle.nodes.ExpressionNode;
import com.albertoventurini.schemino.truffle.types.Arguments;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class AddNode extends BuiltinNode {

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        final Arguments arguments = getArguments(frame);

        long sum = 0;

        try {
            for (int i = 0; i < arguments.size(); i++) {
                //sum += (long) arguments[i];

                long value = arguments.getLong(i);
                sum += value;
            }

            return sum;
        } catch (UnexpectedResultException e) {
            throw new RuntimeException("Need to handle this");
        }
    }

    // TODO: here we need a @Specialization for this node that supports longs... ?
    @Override
    public long executeLong(final VirtualFrame frame) throws UnexpectedResultException {
        final Arguments arguments = getArguments(frame);

        long sum = 0;

        for (int i = 0; i < arguments.size(); i++) {
            long value = arguments.getLong(i);
            sum += value;
        }

        return sum;
    }
}
