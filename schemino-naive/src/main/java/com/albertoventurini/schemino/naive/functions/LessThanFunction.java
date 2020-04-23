package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Arguments;
import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

/**
 * A built-in function that checks if the first argument is less than the second argument.
 */
public class LessThanFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        if (arguments.size() != 2) {
            throw new InvalidArgumentNumber(3, arguments.size());
        }

        // TODO: check the argument types and throw if they are not the same.
        // Apply the correct comparison for different types (e.g. strings, doubles).

        final long left = arguments.getLong(0);
        final long right = arguments.getLong(1);

        return new TypedObject(ScheminoType.BOOLEAN, left < right);
    }

    @Override
    public String toString() {
        return "LessThanFunction";
    }
}
