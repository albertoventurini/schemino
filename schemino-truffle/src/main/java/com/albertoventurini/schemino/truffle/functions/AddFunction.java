//package com.albertoventurini.schemino.truffle.functions;
//
//import com.albertoventurini.schemino.truffle.ScheminoLanguage;
//import com.albertoventurini.schemino.truffle.nodes.root.RootAddNode;
//import com.albertoventurini.schemino.truffle.types.ScheminoFunction;
//import com.oracle.truffle.api.RootCallTarget;
//import com.oracle.truffle.api.Truffle;
//import com.oracle.truffle.api.library.ExportMessage;
//import com.oracle.truffle.api.nodes.IndirectCallNode;
//
///**
// * A built-in function that adds elements and returns the sum.
// * Usage example:
// *
// * (+ 1 2 3) -> 6
// */
//public class AddFunction implements ScheminoFunction {
//
//    private RootCallTarget callTarget;
//
//    public AddFunction(ScheminoLanguage language) {
//        callTarget = Truffle.getRuntime().createCallTarget(new RootAddNode(language));
//    }
//
//    @Override
//    public String toString() {
//        return "AddFunction";
//    }
//
//    @ExportMessage
//    boolean isExecutable() {
//        return true;
//    }
//
//    @Override
//    public Object apply(Object[] arguments) {
//        callTarget.call(arguments);
////        long sum = 0;
////
////        for (int i = 0; i < arguments.length; i++) {
////            sum += (long) arguments[i];
////        }
////
////        return sum;
//    }
//}
