package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Arguments;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A built-in function that appends lists.
 * Example:
 *
 * (append () (1 2) () (3)) -> (1 2 3)
 */
public class AppendFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {

        final List<TypedObject> items = arguments.mapToObj(arguments::getList)
                .flatMap(l -> l.getItems().stream())
                .collect(Collectors.toList());

        return new TypedObject(ScheminoType.LIST, new ScheminoList(items));
    }
}
