package com.albertoventurini.schemino.naive.functions;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;
import java.util.stream.Collectors;

public class AppendFunction implements ScheminoFunction {

    @Override
    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {

        final List<TypedObject> items = arguments
                .stream()
                .map(a -> a.evalList(frame))
                .flatMap(l -> l.getItems().stream())
                .collect(Collectors.toList());

        return new TypedObject(ScheminoType.LIST, new ScheminoList(items));
    }
}
