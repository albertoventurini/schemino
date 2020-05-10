package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.TypedObject;

/**
 * A built-in function that returns the first element of a list.
 * Example:
 *
 * (car [1 2 3]) -> 1
 */
public class CarFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {

        final ScheminoList list = arguments.getList(0);
        if (list.getItems().isEmpty()) {
            throw new RuntimeException("Unable to car an empty list");
        }
        return list.getItems().get(0);
    }

    @Override
    public String toString() {
        return "CarFunction";
    }
}
