package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The 'print' function prints its arguments on the standard output.
 */
public class PrintFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {
        System.out.println(arguments.stream().map(a -> {
            return a.eval(frame).getValue().toString();

        }).collect(Collectors.joining()));

        return new TypedObject(ScheminoType.UNIT, null);
    }
}
