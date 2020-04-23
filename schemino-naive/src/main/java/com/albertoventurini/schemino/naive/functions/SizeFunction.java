package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Arguments;
import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public class SizeFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        if (arguments.size() != 1) {
            throw new InvalidArgumentNumber(1, arguments.size());
        }

        return new TypedObject(ScheminoType.LONG, (long) arguments.getList(0).getItems().size());
    }
}
