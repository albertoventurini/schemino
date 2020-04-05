package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.types.ScheminoDictionary;
import com.albertoventurini.schemino.naive.functions.UserFunction;

public abstract class ExpressionNode extends ScheminoNode {

    public Object eval(final Frame frame) {
        throw new RuntimeException("Not implemented");
    }

    public long evalLong(final Frame frame) {
        throw new RuntimeException("Not implemented");
    }

    public double evalDouble(final Frame frame) {
        throw new RuntimeException("Not implemented");
    }

    public String evalString(final Frame frame) {
        throw new RuntimeException("Not implemented");
    }

    public UserFunction evalFunction(final Frame frame) {
        throw new RuntimeException("Not implemented");
    }

    public ScheminoDictionary evalDictionary(final Frame frame) {
        throw new RuntimeException("Not implemented");
    }


}
