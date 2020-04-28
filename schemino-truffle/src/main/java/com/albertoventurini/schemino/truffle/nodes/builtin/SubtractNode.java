package com.albertoventurini.schemino.truffle.nodes.builtin;

import com.albertoventurini.schemino.truffle.types.Arguments;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class SubtractNode extends BuiltinNode {

    @Override
    public Object execute(final VirtualFrame frame) {
        final Arguments arguments = getArguments(frame);

        if (arguments.isEmpty()) {
            return 0L;
        }

        try {
            long result = arguments.getLong(0);

            for (int i = 1; i < arguments.size(); i++) {
                long value = arguments.getLong(i);
                result -= value;
            }

            return result;
        } catch (UnexpectedResultException e) {
            throw new RuntimeException("Need to handle this");
        }
    }

    // TODO: here we need a @Specialization for this node that supports longs... ?
    @Override
    public long executeLong(final VirtualFrame frame) throws UnexpectedResultException {
        final Arguments arguments = getArguments(frame);

        if (arguments.isEmpty()) {
            return 0L;
        }

        long result = arguments.getLong(0);

        for (int i = 1; i < arguments.size(); i++) {
            long value = arguments.getLong(i);
            result -= value;
        }

        return result;
    }
}
