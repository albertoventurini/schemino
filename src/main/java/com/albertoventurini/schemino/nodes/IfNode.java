package com.albertoventurini.schemino.nodes;

import com.albertoventurini.schemino.ScheminoException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

@NodeInfo(shortName = "if")
public class IfNode extends ExpressionNode {

    @Child private ExpressionNode condition;
    @Child private ExpressionNode thenExpr;
    @Child private ExpressionNode elseExpr;

    public IfNode(
            final ExpressionNode condition,
            final ExpressionNode thenExpr,
            final ExpressionNode elseExpr) {
        this.condition = condition;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        if (evaluateCondition(frame)) {
            return thenExpr.executeGeneric(frame);
        } else {
            return elseExpr.executeGeneric(frame);
        }
    }

    private boolean evaluateCondition(final VirtualFrame frame) {
        try {
            return condition.executeBoolean(frame);
        } catch (UnexpectedResultException e) {
            throw ScheminoException.typeError(condition);
        }
    }
}
