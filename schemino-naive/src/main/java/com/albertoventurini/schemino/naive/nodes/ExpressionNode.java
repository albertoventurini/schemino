package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.exceptions.EvaluationError;
import com.albertoventurini.schemino.naive.types.ScheminoDictionary;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.TypedObject;

public abstract class ExpressionNode extends ScheminoNode {

    public TypedObject eval(final Frame frame) {
        throw new EvaluationError("Unable to evaluated as a TypedObject: " + toString());
    }

    public long evalLong(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a long: " + toString());
    }

    public double evalDouble(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a double: " + toString());
    }

    public boolean evalBoolean(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a boolean: " + toString());
    }

    public String evalString(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a string: " + toString());
    }

    public ScheminoFunction evalFunction(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a function: " + toString());
    }

    public ScheminoDictionary evalDictionary(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a dictionary: " + toString());
    }

    public ScheminoList evalList(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a list: " + toString());
    }
}
