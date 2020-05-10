package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.arguments.ConcreteArguments;
import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.ArrayList;
import java.util.List;

public class FilterFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        if (arguments.size() != 2) {
            throw new InvalidArgumentNumber(2, arguments.size());
        }

        final ScheminoFunction function = arguments.getFunction(0);
        final ScheminoList list = arguments.getList(1);

        final List<TypedObject> filteredItems = new ArrayList<>();

        for (final TypedObject item : list.getItems()) {
            if (function.apply(new ConcreteArguments(List.of(item))).getBooleanOrThrow()) {
                filteredItems.add(item);
            }
        }

        final ScheminoList filteredList = new ScheminoList(filteredItems);
        return new TypedObject(ScheminoType.LIST, filteredList);
    }
}
