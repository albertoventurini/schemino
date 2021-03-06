package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.types.Arguments;
import com.albertoventurini.schemino.truffle.types.ExpressionArguments;
import com.albertoventurini.schemino.truffle.types.ScheminoFunction;
import com.albertoventurini.schemino.truffle.types.ScheminoList;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A node that represents a list.
 *
 * The semantics of a list depends on the context in which it is used:
 * 1. a list can be a sequence of objects, or
 * 2. a list can be a function call.
 *
 * A list is considered a function call if:
 * 1. the requester node explicitly asked for a scalar evaluation of the list
 *    (e.g. `executeLong`, `executeBoolean`, etc.), or
 * 2. the first item evaluates to a ScheminoFunction.
 *
 * Otherwise, the list is considered a sequence of objects.
 */
public class ListNode extends ExpressionNode {

    @Children private ExpressionNode[] items;
    @Child private InteropLibrary library;

    public ListNode(final ExpressionNode[] items) {
        this.items = items;
        this.library = InteropLibrary.getFactory().createDispatched(3);
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        if (items.length == 0) {
            return new ScheminoList(Collections.emptyList());
        }

        final Object firstItemEval = items[0].executeGeneric(frame);

        if (firstItemEval instanceof ScheminoFunction) {
            // call function
            return callFunction(frame, (ScheminoFunction) firstItemEval);
        }

        final List<Object> evaluatedItems = new ArrayList<>(List.of(firstItemEval));

        for (int i = 1; i < items.length; i++) {
            evaluatedItems.add(items[i].executeGeneric(frame));
        }

        return new ScheminoList(evaluatedItems);
    }

//    @Override
//    public long executeLong(final VirtualFrame frame) throws UnexpectedResultException {
//        //final ScheminoFunction firstItemEval = items[0].exe(frame);
//        return callFunction(frame, firstItemEval).getLongOrThrow();
//        return super.executeLong(frame);
//    }
//
//    @Override
//    public boolean executeBoolean(VirtualFrame frame) throws UnexpectedResultException {
//        return super.executeBoolean(frame);
//    }
//
//    @Override
//    public String executeString(VirtualFrame frame) throws UnexpectedResultException {
//        return super.executeString(frame);
//    }
//
//    @Override
//    public long executeLong(final Frame frame) {
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
//

    private Object callFunction(final VirtualFrame frame, final ScheminoFunction function) {
        final Arguments args =
                new ExpressionArguments(frame.materialize(), Arrays.copyOfRange(items, 1, items.length));

        try {
            return library.execute(function, args);
        } catch (ArityException | UnsupportedTypeException | UnsupportedMessageException e) {
            /* Execute was not successful. */
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "(" + Arrays.stream(items).map(Object::toString).collect(Collectors.joining(" ")) + ")";
    }
}
