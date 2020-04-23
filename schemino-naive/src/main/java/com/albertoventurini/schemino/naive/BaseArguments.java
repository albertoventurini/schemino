package com.albertoventurini.schemino.naive;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class BaseArguments<T> implements Arguments {

    protected final List<T> items;

    protected BaseArguments(final List<T> items) {
        this.items = items;
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public <U> Stream<U> mapToObj(IntFunction<? extends U> mapper) {
        return IntStream.range(0, items.size()).mapToObj(mapper);
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }
}
