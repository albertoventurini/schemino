package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

/**
 * A built-in function that takes one parameter of type list,
 * and returns the parameter evaluated as a list.
 *
 * (quote (1 2 3 4 5)) => (1 2 3 4 5)
 * (quote (+ - * /)) => (+ - * /) [list of functions]
 */
public class QuoteFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        if (arguments.size() != 1) {
            throw new InvalidArgumentNumber(1, arguments.size());
        }

        return new TypedObject(ScheminoType.LIST, arguments.getList(0));
    }
}
