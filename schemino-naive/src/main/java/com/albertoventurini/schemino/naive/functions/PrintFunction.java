package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.stream.Collectors;

/** Print the arguments on the standard output */
public class PrintFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        System.out.println(
                arguments.mapToObj(i -> arguments.get(i).getValue().toString()).collect(Collectors.joining())
        );

        return new TypedObject(ScheminoType.UNIT, null);
    }
}
