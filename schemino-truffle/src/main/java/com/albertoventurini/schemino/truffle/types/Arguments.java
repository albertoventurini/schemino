package com.albertoventurini.schemino.truffle.types;

import com.oracle.truffle.api.nodes.UnexpectedResultException;

import java.util.function.IntFunction;
import java.util.stream.Stream;

/**
 * Contains arguments that can be passed to functions.
 */
public interface Arguments {

    int size();

    boolean isEmpty();

    Object get(int i);

    boolean getBoolean(int i) throws UnexpectedResultException;

    long getLong(int i) throws UnexpectedResultException;

    ScheminoList getList(int i) throws UnexpectedResultException;

    ScheminoFunction getFunction(int i) throws UnexpectedResultException;

    <T> Stream<T> mapToObj(IntFunction<? extends T> mapper);
}
