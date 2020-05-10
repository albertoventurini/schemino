package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;
import java.util.stream.Collectors;

/** A node that represents a list */
public class ListNode extends ExpressionNode {

    private final List<ExpressionNode> items;

    public ListNode(final List<ExpressionNode> items) {
        this.items = items;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        final List<TypedObject> evaluatedItems = items
                .stream()
                .map(i -> i.eval(frame))
                .collect(Collectors.toUnmodifiableList());

        return new TypedObject(ScheminoType.LIST, new ScheminoList(evaluatedItems));
    }

    /**
     * Evaluate this node as a list.
     * @param frame the evaluation frame
     * @return a ScheminoList containing evaluated items
     */
    @Override
    public ScheminoList evalList(final Frame frame) {
        final List<TypedObject> evaluatedItems = items
                .stream()
                .map(i -> i.eval(frame))
                .collect(Collectors.toUnmodifiableList());

        return new ScheminoList(evaluatedItems);
    }

    @Override
    public String toString() {
        return "(" + items.stream().map(Object::toString).collect(Collectors.joining(" ")) + ")";
    }
}
