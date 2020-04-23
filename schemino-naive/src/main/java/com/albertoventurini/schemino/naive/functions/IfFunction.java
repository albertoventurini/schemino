package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Arguments;
import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class IfFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        if (arguments.size() != 3) {
            throw new InvalidArgumentNumber(3, arguments.size());
        }

        if (arguments.getBoolean(0)) {
            return arguments.get(1);
        } else {
            return arguments.get(2);
        }
    }

    @Override
    public String toString() {
        return "IfFunction";
    }
}
