package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

/**
 * A built-in function that takes one parameter of type list,
 * and returns the parameter evaluated as a list.
 *
 * (quote (1 2 3 4 5)) => (1 2 3 4 5)
 * (quote (+ - * /)) => (+ - * /) [list of functions]
 */
public class QuoteFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {
        if (arguments.size() != 1) {
            throw new InvalidArgumentNumber(1, arguments.size());
        }

        return new TypedObject(ScheminoType.LIST, arguments.get(0).evalList(frame));
    }
}