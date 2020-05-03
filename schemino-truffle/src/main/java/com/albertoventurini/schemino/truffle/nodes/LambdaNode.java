package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.albertoventurini.schemino.truffle.runtime.ScheminoContext;
import com.albertoventurini.schemino.truffle.types.ScheminoFunction;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.source.Source;

import java.util.List;

@NodeInfo(shortName = "lambda")
//@NodeChild("body")
@GenerateNodeFactory
public abstract class LambdaNode extends ExpressionNode {

    private final List<String> parameters;
    @Child private ExpressionNode body;

    // A lambda node evaluates to a function
//
    public LambdaNode(final List<String> parameters, final ExpressionNode body) {
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public final Object executeGeneric(VirtualFrame frame) {
        try {
            return execute(frame);
        } catch (UnsupportedSpecializationException e) {
            throw new RuntimeException(e);
        }
    }

    @Specialization
    public ScheminoFunction defineFunction() {
        return new ScheminoFunction(new EvalRootNode(null, body));
    }

    protected abstract Object execute(VirtualFrame frame);

}
