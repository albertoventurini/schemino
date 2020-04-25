package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;

public abstract class StatementNode  extends ScheminoNode {


    protected StatementNode(ScheminoLanguage language) {
        super(language);
    }

    protected StatementNode(ScheminoLanguage language, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }

    @Override
    public Object execute(VirtualFrame virtualFrame) {
        return null;
    }
}
