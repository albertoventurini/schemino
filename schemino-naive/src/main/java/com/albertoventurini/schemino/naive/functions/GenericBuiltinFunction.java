package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.arguments.Arguments;
import com.albertoventurini.schemino.naive.exceptions.TypeMismatch;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

public abstract class GenericBuiltinFunction<T> implements ScheminoFunction {

    @FunctionalInterface
    interface TypedObjectFunc<U> {
        U apply(final TypedObject... objects);
    }

    private final ScheminoType scheminoType;
    private final TypedObjectFunc<T> function;

    protected GenericBuiltinFunction(
            final ScheminoType scheminoType,
            final TypedObjectFunc<T> function) {

        this.scheminoType = scheminoType;
        this.function = function;
    }

    @Override
    public TypedObject apply(final Arguments arguments) {
        final TypedObject[] objects = new TypedObject[arguments.size()];

        for (int i = 0; i < arguments.size(); i++) {
            final TypedObject object = arguments.get(i);
            if (object.getType() != scheminoType) {
                throw new TypeMismatch(scheminoType, object.getType());
            }

            objects[i] = object;
        }

        return new TypedObject(scheminoType, function.apply(objects));
    }
}
