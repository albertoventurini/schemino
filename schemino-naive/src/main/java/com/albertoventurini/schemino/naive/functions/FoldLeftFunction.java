//package com.albertoventurini.schemino.naive.functions;
//
//import com.albertoventurini.schemino.naive.Frame;
//import com.albertoventurini.schemino.naive.exceptions.InvalidArgumentNumber;
//import com.albertoventurini.schemino.naive.nodes.ExpressionNode;
//import com.albertoventurini.schemino.naive.nodes.ListNode;
//import com.albertoventurini.schemino.naive.types.ScheminoFunction;
//import com.albertoventurini.schemino.naive.types.ScheminoList;
//import com.albertoventurini.schemino.naive.types.TypedObject;
//
//import java.util.List;
//
//public class FoldLeftFunction implements ScheminoFunction {
//
//    @Override
//    public TypedObject apply(final Frame frame, final List<ExpressionNode> arguments) {
//        if (arguments.size() != 3) {
//            throw new InvalidArgumentNumber(3, arguments.size());
//        }
//
//        if (!(arguments.get(2) instanceof ListNode)) {
//            throw new RuntimeException("List expected, but was not given");
//        }
//
//        final ScheminoFunction function = arguments.get(0).evalFunction(frame);
//        final ExpressionNode zero = arguments.get(1);
//        final ListNode argumentList = (ListNode) arguments.get(2);
//
//        ExpressionNode prev = zero;
//
//        for (final ExpressionNode argument : argumentList.getItems()) {
//            // Create a new frame that points to the current frame
//            final Frame functionFrame = Frame.fromParent(frame);
//
//            function.apply(functionFrame, List.of(prev, argument));
//
//            prev = argument;
//        }
//    }
//
//    private TypedObject applyFunc(final ScheminoFunction function, final List<ExpressionNode> arguments) {
//
//    }
//}
