package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class AndFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        // TODO: check the argument types and throw if they are not the same.
        // Apply the correct sum for different types (e.g. strings, doubles).

        for (int i = 0; i < arguments.size(); i++) {
            if (!arguments.getBoolean(i)) {
                return new TypedObject(ScheminoType.BOOLEAN, false);
            }
        }

        return new TypedObject(ScheminoType.BOOLEAN, true);
    }

    @Override
    public String toString() {
        return "AndFunction";
    }
}
