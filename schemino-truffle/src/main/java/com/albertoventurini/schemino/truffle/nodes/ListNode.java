package com.albertoventurini.schemino.truffle.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A node that represents a list.
 *
 * The semantics of a list depends on the context in which it is used:
 * - a list can be a sequence of objects, or
 * - a list can be a function call
 *
 * A list is considered a function call if:
 * - the requester explicitly asks a scalar evaluation of the list
 *   (e.g. `evalLong`, `evalBoolean`, etc.), or
 * - the first item evaluates to a ScheminoFunction
 *
 * Otherwise, the list is considered a sequence of objects.
 */
public class ListNode extends ExpressionNode {

    private final List<ExpressionNode> items;

    public ListNode(final List<ExpressionNode> items) {
        this.items = items;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return null;
    }

    //    @Override
//    public TypedObject eval(final Frame frame) {
//        if (items.isEmpty()) {
//            return new TypedObject(ScheminoType.LIST, new ScheminoList(Collections.emptyList()));
//        }
//
//        final TypedObject firstItemEval = items.get(0).eval(frame);
//
//        if (firstItemEval.getType().equals(ScheminoType.FUNCTION)) {
//            return callFunction(frame, firstItemEval.getFunctionOrThrow());
//        }
//
//        final List<TypedObject> evaluatedItems = new ArrayList<>(List.of(firstItemEval));
//
//        if (items.size() > 1) {
//            items.stream().skip(1).forEach(item -> evaluatedItems.add(item.eval(frame)));
//        }
//
//        return new TypedObject(ScheminoType.LIST, new ScheminoList(evaluatedItems));
//    }
//
//    @Override
//    public long evalLong(final Frame frame) {
//        // When a list is evaluated as a long, we assume it's a function call
//        final ScheminoFunction firstItemEval = items.get(0).evalFunction(frame);
//        return callFunction(frame, firstItemEval).getLongOrThrow();
//    }
//
//    @Override
//    public boolean evalBoolean(final Frame frame) {
//        // When a list is evaluated as a boolean, we assume it's a function call
//        final ScheminoFunction firstItemEval = items.get(0).evalFunction(frame);
//        return callFunction(frame, firstItemEval).getBooleanOrThrow();
//    }
//
//    /**
//     * Evaluate this node as a list.
//     * @param frame the evaluation frame
//     * @return a ScheminoList containing evaluated items
//     */
//    @Override
//    public ScheminoList evalList(final Frame frame) {
//        final List<TypedObject> evaluatedItems = items
//                .stream()
//                .map(i -> i.eval(frame))
//                .collect(Collectors.toUnmodifiableList());
//
//        return new ScheminoList(evaluatedItems);
//    }
//
//    /**
//     * Consider this list as a function call. The first items contains the function to call,
//     * the other items are the arguments.
//     * @param frame the evaluation frame
//     * @param function the function to call, which has been already evaluated
//     * @return the result of the function call
//     */
//    private TypedObject callFunction(final Frame frame, final ScheminoFunction function) {
//        if (function == null) {
//            throw new InvalidFunction();
//        }
//
//        // Collect the arguments. Skip 1 because the first item is the function expression.
//        final Arguments arguments = new ExpressionArguments(frame, items.stream().skip(1).collect(Collectors.toList()));
//
//        // Apply the function
//        return function.apply(arguments);
//    }

    @Override
    public String toString() {
        return "(" + items.stream().map(Object::toString).collect(Collectors.joining(" ")) + ")";
    }
}
