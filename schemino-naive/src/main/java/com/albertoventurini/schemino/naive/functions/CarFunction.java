package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.TypedObject;

/**
 * A built-in function that returns the first element of a list.
 * Example:
 *
 * (car (1 2 3)) -> 1
 */
public class CarFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        // TODO: check number of arguments
        final ScheminoList list = arguments.getList(0);
        return list.getItems().get(0);
    }

    @Override
    public String toString() {
        return "CarFunction";
    }
}
