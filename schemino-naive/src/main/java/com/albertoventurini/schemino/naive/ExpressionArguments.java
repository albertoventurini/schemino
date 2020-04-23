package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

/**
 * Represents arguments that will be evaluated on a specific execution frame.
 */
public class ExpressionArguments extends BaseArguments<ExpressionNode> implements Arguments {

    private final Frame frame;

    public ExpressionArguments(final Frame frame, final List<ExpressionNode> expressions) {
        super(expressions);
        this.frame = frame;
    }

    @Override
    public TypedObject get(int i) {
        return items.get(i).eval(frame);
    }

    @Override
    public boolean getBoolean(int i) {
        return items.get(i).evalBoolean(frame);
    }

    @Override
    public long getLong(int i) {
        return items.get(i).evalLong(frame);
    }

    @Override
    public ScheminoList getList(int i) {
        return items.get(i).evalList(frame);
    }

    @Override
    public ScheminoFunction getFunction(int i) {
        return items.get(i).evalFunction(frame);
    }
}
