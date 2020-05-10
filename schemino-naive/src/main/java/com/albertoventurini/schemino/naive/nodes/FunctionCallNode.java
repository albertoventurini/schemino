package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.ExecutionContext;
import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.arguments.EagerArguments;
import com.albertoventurini.schemino.naive.arguments.LazyArguments;
import com.albertoventurini.schemino.naive.exceptions.InvalidFunction;
import com.albertoventurini.schemino.naive.exceptions.TailCall;
import com.albertoventurini.schemino.naive.exceptions.TypeMismatch;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class FunctionCallNode extends ExpressionNode {

    private final ExpressionNode functionExpr;
    private final List<ExpressionNode> argumentExprs;

    public FunctionCallNode(final ExpressionNode functionExpr, final List<ExpressionNode> argumentExprs) {
        this.functionExpr = functionExpr;
        this.argumentExprs = argumentExprs;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        return callFunction(frame);
    }

    @Override
    public long evalLong(final Frame frame) {
        final TypedObject object = callFunction(frame);
        if (object.getType() != ScheminoType.LONG) {
            throw new RuntimeException("Expected long, got " + object.getType() + ": " + object.toString());
        }
        return object.getLongOrThrow();
    }

    @Override
    public boolean evalBoolean(final Frame frame) {
        return callFunction(frame).getBooleanOrThrow();
    }

    private TypedObject callFunction(final Frame frame) {
        final ScheminoFunction function = functionExpr.evalFunction(frame);

        if (function == null) {
            throw new InvalidFunction();
        }

        final Arguments arguments;

        if (function.isTailRecursive()) {
            arguments = new EagerArguments(frame, argumentExprs);
        } else {
            arguments = new LazyArguments(frame, argumentExprs);
        }

        if (function.isTailRecursive() && !ExecutionContext.functionStack.empty()
                && ExecutionContext.functionStack.stream().anyMatch(f -> f.equals(function))) {
            throw new TailCall(arguments);
        }

        ExecutionContext.functionStack.push(function);

        return function.apply(arguments);
    }
}
