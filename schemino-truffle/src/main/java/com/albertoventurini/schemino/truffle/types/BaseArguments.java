package com.albertoventurini.schemino.truffle.types;

import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class BaseArguments<T> implements Arguments {

    protected final T[] items;

    protected BaseArguments(final T[] items) {
        this.items = items;
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public <U> Stream<U> mapToObj(IntFunction<? extends U> mapper) {
        return IntStream.range(0, items.length).mapToObj(mapper);
    }

    @Override
    public boolean isEmpty() {
        return items.length == 0;
    }
}
