package com.albertoventurini.schemino.nodes;

import com.albertoventurini.schemino.ScheminoLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

// TODO: understand!
public class EvalRootNode extends RootNode {
    public EvalRootNode(ScheminoLanguage language) {
        super(language);
    }

    protected EvalRootNode(ScheminoLanguage language, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return 42;
    }
}
