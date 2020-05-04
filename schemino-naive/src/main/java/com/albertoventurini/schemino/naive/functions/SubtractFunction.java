package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class SubtractFunction implements ScheminoFunction {
    @Override
    public TypedObject apply(final Arguments arguments) {
        if (arguments.isEmpty()) {
            return new TypedObject(ScheminoType.LONG, 0L);
        }

        long result = arguments.getLong(0);

        // TODO: check the argument types and throw if they are not the same.

        for (int i = 1; i < arguments.size(); i++) {
            result -= arguments.getLong(i);
        }

        return new TypedObject(ScheminoType.LONG, result);
    }

    @Override
    public String toString() {
        return "SubtractFunction";
    }
}
