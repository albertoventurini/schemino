package com.albertoventurini.schemino.truffle.types;

import com.albertoventurini.schemino.truffle.nodes.ExpressionNode;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

/**
 * Represents arguments that will be evaluated on a specific execution frame.
 */
public class ExpressionArguments extends BaseArguments<ExpressionNode> implements Arguments {

    private final MaterializedFrame frame;

    public ExpressionArguments(final MaterializedFrame frame, final ExpressionNode[] expressions) {
        super(expressions);
        this.frame = frame;
    }

    @Override
    public Object get(int i) {
        return items[i].execute(frame);
    }

    @Override
    public boolean getBoolean(int i) throws UnexpectedResultException {
        return items[i].executeBoolean(frame);
    }

    @Override
    public long getLong(int i) throws UnexpectedResultException {
        return items[i].executeLong(frame);
    }

    @Override
    public ScheminoList getList(int i) {
//        return items.get(i).executeList(frame);
        return null;
    }

    @Override
    public ScheminoFunction getFunction(int i) {
//        return items.get(i).executeFunction(frame);
        return null;
    }
}
