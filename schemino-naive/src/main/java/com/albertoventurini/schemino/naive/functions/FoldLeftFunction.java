package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Arguments;
import com.albertoventurini.schemino.naive.ConcreteArguments;
import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
import com.albertoventurini.schemino.naive.exceptions.TypeMismatch;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

/**
 * A built-in function that iterates through a list and applies a binary function,
 * where the function arguments are the previous result and the current list element.
 *
 * Example:
 *
 * (fold-left + 0 (1 2 3)) -> 6
 */
public class FoldLeftFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Arguments arguments) {
        if (arguments.size() != 3) {
            throw new InvalidArgumentNumber(3, arguments.size());
        }

        if (arguments.get(2).getType() != ScheminoType.LIST) {
            throw new TypeMismatch(ScheminoType.LIST, arguments.get(2).getType());
        }

        final ScheminoFunction function = arguments.getFunction(0);
        final TypedObject zero = arguments.get(1);
        final ScheminoList argumentList = arguments.getList(2);

        TypedObject acc = zero;

        for (final TypedObject curr : argumentList.getItems()) {
            final Arguments args = new ConcreteArguments(List.of(acc, curr));
            acc = function.apply(args);
        }

        return acc;
    }
}
