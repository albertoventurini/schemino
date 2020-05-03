package com.albertoventurini.schemino.truffle.types;

//import com.albertoventurini.schemino.truffle.functions.AddFunction;
import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.RootNode;

/**
 * Generic interface for Schemino functions.
 */
@ExportLibrary(InteropLibrary.class)
public final class ScheminoFunction implements TruffleObject {

    private final RootCallTarget callTarget;

    public RootCallTarget getCallTarget() {
        return callTarget;
    }

    public ScheminoFunction(final RootNode rootNode) {
        this.callTarget = Truffle.getRuntime().createCallTarget(rootNode);
    }

    @ExportMessage
    boolean isExecutable() {
        return true;
    }

    @ExportMessage
    abstract static class Execute {


//        @Specialization(limit = "INLINE_CACHE_SIZE", //
//                guards = "function.getCallTarget() == cachedTarget", //
//                assumptions = "callTargetStable")
        @SuppressWarnings("unused")
        protected static Object doDirect(ScheminoFunction function, Object[] arguments,
                                         @Cached("function.getCallTargetStable()") Assumption callTargetStable,
                                         @Cached("function.getCallTarget()") RootCallTarget cachedTarget,
                                         @Cached("create(cachedTarget)") DirectCallNode callNode) {

            /* Inline cache hit, we are safe to execute the cached call target. */
            Object returnValue = callNode.call(arguments);
            return returnValue;
        }

        /**
         * Slow-path code for a call, used when the polymorphic inline cache exceeded its maximum
         * size specified in <code>INLINE_CACHE_SIZE</code>. Such calls are not optimized any
         * further, e.g., no method inlining is performed.
         */
//        @Specialization(replaces = "doDirect")
        protected static Object doIndirect(ScheminoFunction function, Object[] arguments,
                                           @Cached IndirectCallNode callNode) {
            /*
             * SL has a quite simple call lookup: just ask the function for the current call target,
             * and call it.
             */
            return callNode.call(function.getCallTarget(), arguments);
        }

        @Specialization static Object doDefault(ScheminoFunction function, Object[] arguments) {
            return function.getCallTarget().call(function.getCallTarget(), arguments);
        }
    }

}
