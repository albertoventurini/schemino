package com.albertoventurini.schemino.naive.arguments;

import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

/**
 * Represents arguments that don't have to be evaluated. I.e. they already have concrete values.
 */
public class ConcreteArguments extends BaseArguments<TypedObject> implements Arguments {

    public ConcreteArguments(final List<TypedObject> objects) {
        super(objects);
    }

    @Override
    public TypedObject get(int i) {
        return items.get(i);
    }

    @Override
    public boolean getBoolean(int i) {
        return items.get(i).getBooleanOrThrow();
    }

    @Override
    public long getLong(int i) {
        return items.get(i).getLongOrThrow();
    }

    @Override
    public ScheminoList getList(int i) {
        return items.get(i).getListOrThrow();
    }

    @Override
    public ScheminoFunction getFunction(int i) {
        return items.get(i).getFunctionOrThrow();
    }
}
