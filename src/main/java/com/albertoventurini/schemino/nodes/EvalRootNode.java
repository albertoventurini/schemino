package com.albertoventurini.schemino.nodes;

import com.albertoventurini.schemino.ScheminoLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

// TODO: understand!
// A root note that can be evaluated?
public class EvalRootNode extends RootNode {
    public EvalRootNode(final ScheminoLanguage language) {
        super(language);
    }

    @Child private ExpressionNode child = AddNodeGen.create(
            new LongNode(1),
            new LongNode(41)
    );

    protected EvalRootNode(final ScheminoLanguage language, final FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }

    @Override
    public Object execute(final VirtualFrame frame) {
        return child.executeGeneric(frame);
    }
}
