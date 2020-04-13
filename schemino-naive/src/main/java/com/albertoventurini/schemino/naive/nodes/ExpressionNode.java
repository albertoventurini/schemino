package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.exceptions.EvaluationError;
import com.albertoventurini.schemino.naive.types.ScheminoDictionary;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoList;
import com.albertoventurini.schemino.naive.types.TypedObject;

public abstract class ExpressionNode extends ScheminoNode {

    public TypedObject eval(final Frame frame) {
        throw new EvaluationError("Not implemented");
    }

    public long evalLong(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a long");
    }

    public double evalDouble(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a double");
    }

    public boolean evalBoolean(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a boolean");
    }

    public String evalString(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a string");
    }

    public ScheminoFunction evalFunction(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a function");
    }

    public ScheminoDictionary evalDictionary(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a dictionary");
    }

    public ScheminoList evalList(final Frame frame) {
        throw new EvaluationError("Unable to evaluate as a list");
    }


}
