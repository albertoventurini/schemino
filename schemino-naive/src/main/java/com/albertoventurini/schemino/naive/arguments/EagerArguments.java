package com.albertoventurini.schemino.naive.arguments;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Represents arguments that will be evaluated on a specific execution frame.
 */
public class EagerArguments implements Arguments {

    private final Frame frame;

    private final List<TypedObject> items = new ArrayList<>();

    public EagerArguments(final Frame frame, final List<ExpressionNode> expressions) {
        items.addAll(expressions.stream().map(e -> e.eval(frame)).collect(Collectors.toList()));
        this.frame = frame;
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
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

    @Override
    public <T> Stream<T> mapToObj(IntFunction<? extends T> mapper) {
        return IntStream.range(0, items.size()).mapToObj(mapper);
    }
}
