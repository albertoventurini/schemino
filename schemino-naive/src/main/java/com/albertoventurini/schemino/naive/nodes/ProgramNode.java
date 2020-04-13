package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.functions.AddFunction;
import com.albertoventurini.schemino.naive.functions.GreaterThanFunction;
import com.albertoventurini.schemino.naive.functions.IfFunction;
import com.albertoventurini.schemino.naive.functions.SubtractFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class ProgramNode extends ExpressionNode {

    private List<ExpressionNode> expressions;

    public ProgramNode(final List<ExpressionNode> expressions) {
        this.expressions = expressions;
    }

    public TypedObject run() {
        final Frame frame = Frame.root();

        frame.putFunction("+", new AddFunction());
        frame.putFunction("-", new SubtractFunction());
        frame.putFunction("if", new IfFunction());
        frame.putFunction(">", new GreaterThanFunction());

        return eval(frame);
    }

    @Override
    public TypedObject eval(final Frame frame) {
        for (int i = 0; i < expressions.size() - 1; i++) {
            expressions.get(i).eval(frame);
        }

        return expressions.get(expressions.size() - 1).eval(frame);
    }
}
