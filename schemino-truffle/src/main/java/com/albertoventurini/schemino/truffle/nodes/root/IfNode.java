package com.albertoventurini.schemino.truffle.nodes.root;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class IfNode extends RootNode {
    protected IfNode(ScheminoLanguage language) {
        super(language);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return null;
    }
}
