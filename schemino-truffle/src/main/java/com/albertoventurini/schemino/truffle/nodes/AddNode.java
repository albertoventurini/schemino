package com.albertoventurini.schemino.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

@NodeInfo(shortName = "+")
public class AddNode extends ExpressionNode {

    @Children private ExpressionNode[] expressions;

    public AddNode(final ExpressionNode[] expressions) {
        this.expressions = expressions;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        // TODO: throw appropriate exception, so the node specialises to Long
        long sum = 0;

        for (int i = 0; i < expressions.length; i++) {
            sum += (long) expressions[i].execute(frame);
        }

        return sum;
    }

    @Override
    public long executeLong(final VirtualFrame frame) throws UnexpectedResultException {
        long sum = 0;

        for (int i = 0; i < expressions.length; i++) {
            sum += expressions[i].executeLong(frame);
        }

        return sum;
    }
}
