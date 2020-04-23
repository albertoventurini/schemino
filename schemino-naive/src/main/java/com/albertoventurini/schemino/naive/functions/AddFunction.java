package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

/**
 * A built-in function that adds elements and returns the sum.
 * Usage example:
 *
 * (+ 1 2 3) -> 6
 */
public class AddFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        long sum = 0;

        // TODO: check the argument types and throw if they are not the same.
        // Apply the correct sum for different types (e.g. strings, doubles).

        for (int i = 0; i < arguments.size(); i++) {
            sum += arguments.getLong(i);
        }

        return new TypedObject(ScheminoType.LONG, sum);
    }

    @Override
    public String toString() {
        return "AddFunction";
    }
}
