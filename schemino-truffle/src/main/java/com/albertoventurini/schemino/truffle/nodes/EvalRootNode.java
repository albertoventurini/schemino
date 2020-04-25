package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class EvalRootNode extends RootNode {
    private ExpressionNode expressionNode;

    public EvalRootNode(
            final ScheminoLanguage language,
            final ExpressionNode expressionNode,
            final FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
        this.expressionNode = expressionNode;
    }

    public EvalRootNode(final ScheminoLanguage language, final ExpressionNode expressionNode) {
        super(language);
        this.expressionNode = expressionNode;
    }

    @Override
    public Object execute(final VirtualFrame frame) {
        return expressionNode.execute(frame);
    }
}
