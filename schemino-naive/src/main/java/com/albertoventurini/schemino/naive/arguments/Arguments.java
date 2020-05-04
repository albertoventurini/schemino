package com.albertoventurini.schemino.naive.arguments;

import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.function.IntFunction;
import java.util.stream.Stream;

/**
 * Contains arguments that can be passed to functions.
 */
public interface Arguments {

    int size();

    boolean isEmpty();

    TypedObject get(int i);

    boolean getBoolean(int i);

    long getLong(int i);

    ScheminoList getList(int i);

    ScheminoFunction getFunction(int i);

    <T> Stream<T> mapToObj(IntFunction<? extends T> mapper);
}
