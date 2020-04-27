package com.albertoventurini.schemino.truffle.functions;

import com.albertoventurini.schemino.truffle.types.ScheminoFunction;

/**
 * A built-in function that adds elements and returns the sum.
 * Usage example:
 *
 * (+ 1 2 3) -> 6
 */
public class AddFunction implements ScheminoFunction {

    @Override
    public String toString() {
        return "AddFunction";
    }

    @Override
    public Object apply(Object[] arguments) {
        long sum = 0;

        for (int i = 0; i < arguments.length; i++) {
            sum += (long) arguments[i];
        }

        return sum;
    }
}
