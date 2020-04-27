package com.albertoventurini.schemino.truffle.nodes.root;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.albertoventurini.schemino.truffle.nodes.ExpressionNode;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameInstance;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class AddNode extends RootNode {

    public AddNode(ScheminoLanguage language) {
        super(language);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object[] arguments = (Object[]) frame.getArguments()[1];

        long sum = 0;

        MaterializedFrame parentFrame = (MaterializedFrame) arguments[0];

        try {
            for (int i = 1; i < arguments.length; i++) {
                //sum += (long) arguments[i];

                long value = ((ExpressionNode) arguments[i]).executeLong(parentFrame);
                sum += value;
            }

            return sum;
        } catch (UnexpectedResultException e) {
            throw new RuntimeException("Need to handle this");

            // TODO: here we need a @Specialization for this node that supports longs... ?
        }
    }
}
