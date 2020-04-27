package com.albertoventurini.schemino.truffle.types;

import com.oracle.truffle.api.interop.TruffleObject;

/**
 * Generic interface for Schemino functions.
 */
public interface ScheminoFunction extends TruffleObject {
    /**
     * Apply the arguments to the function parameters, then
     * execute the function body and return its result.
     *
     * @param arguments the arguments to be passed to the function
     * @return the result of executing the function
     */
    Object apply(Object[] arguments);
}
