package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.functions.AddFunction;
import com.albertoventurini.schemino.naive.functions.AndFunction;
import com.albertoventurini.schemino.naive.functions.AppendFunction;
import com.albertoventurini.schemino.naive.functions.CarFunction;
import com.albertoventurini.schemino.naive.functions.CdrFunction;
import com.albertoventurini.schemino.naive.functions.CondFunction;
import com.albertoventurini.schemino.naive.functions.EqualsFunction;
import com.albertoventurini.schemino.naive.functions.FoldLeftFunction;
import com.albertoventurini.schemino.naive.functions.GreaterThanFunction;
import com.albertoventurini.schemino.naive.functions.IfFunction;
import com.albertoventurini.schemino.naive.functions.LessThanFunction;
import com.albertoventurini.schemino.naive.functions.PrintFunction;
import com.albertoventurini.schemino.naive.functions.QuoteFunction;
import com.albertoventurini.schemino.naive.functions.SizeFunction;
import com.albertoventurini.schemino.naive.functions.SubtractFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

/**
 * The root node of a Schemino program.
 */
public class ProgramNode extends ExpressionNode {

    /**
     * The expressions that make up the program
     */
    private final List<ExpressionNode> expressions;

    public ProgramNode(final List<ExpressionNode> expressions) {
        this.expressions = expressions;
    }

    /**
     * Run the program and return the result of its last expression
     * @return the result of the last expression in the program
     */
    public TypedObject run() {
        final Frame frame = Frame.root();

        // Set up built-in functions
        frame.putFunction("+", new AddFunction());
        frame.putFunction("-", new SubtractFunction());
        frame.putFunction("=", new EqualsFunction());
        frame.putFunction("and", new AndFunction());
        frame.putFunction("quote", new QuoteFunction());
        frame.putFunction("if", new IfFunction());
        frame.putFunction("cond", new CondFunction());
        frame.putFunction(">", new GreaterThanFunction());
        frame.putFunction("<", new LessThanFunction());
        frame.putFunction("print", new PrintFunction());
        frame.putFunction("car", new CarFunction());
        frame.putFunction("cdr", new CdrFunction());
        frame.putFunction("append", new AppendFunction());
        frame.putFunction("size", new SizeFunction());
        frame.putFunction("fold-left", new FoldLeftFunction());

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
