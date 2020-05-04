package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.stream.Collectors;

/**
 * The 'print' function prints its arguments on the standard output.
 */
public class PrintFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        System.out.println(
                arguments.mapToObj(i -> arguments.get(i).getValue().toString()).collect(Collectors.joining())
        );
//        System.out.println(arguments.stream().map(a -> {
//            return a.eval(frame).getValue().toString();
//
//        }).collect(Collectors.joining()));

        return new TypedObject(ScheminoType.UNIT, null);
    }
}
