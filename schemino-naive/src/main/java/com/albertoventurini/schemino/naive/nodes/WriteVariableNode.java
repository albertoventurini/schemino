package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

/**
 * A node that writes a variable onto the current execution frame.
 */
public class WriteVariableNode extends ExpressionNode {

    /**
     * The symbol that identifies the variable.
     */
    private final SymbolNode symbolNode;

    /**
     * The expression that evaluates to the value of the variable.
     */
    private final ExpressionNode expression;

    public WriteVariableNode(
            final SymbolNode symbolNode,
            final ExpressionNode expressionNode) {

        this.symbolNode = symbolNode;
        this.expression = expressionNode;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        if (expression instanceof LongNode) {
            return new TypedObject(ScheminoType.LONG, evalLong(frame));
        } else if (expression instanceof LambdaNode) {
            return new TypedObject(ScheminoType.FUNCTION, evalFunction(frame));
        } else if (expression instanceof ReadVariableNode) {
            final String name = symbolNode.evalString(frame);
            final TypedObject value = expression.eval(frame);
            frame.putObject(name, value);

            return value;
        }

        throw new RuntimeException("unsupported");
    }

    @Override
    public long evalLong(final Frame frame) {
        final String name = symbolNode.evalString(frame);
        final long value = expression.evalLong(frame);
        frame.putLong(name, value);

        return value;
    }

    @Override
    public ScheminoFunction evalFunction(final Frame frame) {
        final String name = symbolNode.evalString(frame);
        final ScheminoFunction value = expression.evalFunction(frame);
        frame.putFunction(name, value);

        return value;
    }
}
