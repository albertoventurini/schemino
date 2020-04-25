package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;

public class AssignmentNode extends StatementNode {
    protected AssignmentNode(ScheminoLanguage language) {
        super(language);
    }

    protected AssignmentNode(ScheminoLanguage language, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }
}
