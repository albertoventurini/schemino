package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

/**
 * A built-in function that checks if all arguments are equals.
 * Example:
 *
 * (= 1 1 1) -> true
 * (= 0 1) -> false
 */
public class EqualsFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {

        // The 'zero' of equals is true
        if (arguments.size() == 0) {
            return new TypedObject(ScheminoType.BOOLEAN, true);
        }

        final boolean allEquals = arguments.mapToObj(arguments::getLong)
                .distinct()
                .count() == 1;

        return new TypedObject(ScheminoType.BOOLEAN, allEquals);
    }

    @Override
    public String toString() {
        return "EqualsFunction";
    }
}
