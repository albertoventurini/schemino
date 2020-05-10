package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.stream.Collectors;

/**
 * A built-in function that returns the tail of a list.
 * Example:
 *
 * (cdr [1 2 3]) -> [2 3]
 */
public class CdrFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        // TODO: check number of arguments
        final ScheminoList list = arguments.getList(0);

        return new TypedObject(
                ScheminoType.LIST, new ScheminoList(list.getItems().stream().skip(1).collect(Collectors.toList())));
    }
}
