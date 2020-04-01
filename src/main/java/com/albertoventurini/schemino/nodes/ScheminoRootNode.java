package com.albertoventurini.schemino.nodes;

import com.albertoventurini.schemino.ScheminoLanguage;
import com.albertoventurini.schemino.ScheminoTypesGen;
import com.albertoventurini.schemino.types.ScheminoList;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

@NodeInfo(language = "schemino", description = "The root of all nodes")
public abstract class ScheminoRootNode extends RootNode {

    protected ScheminoRootNode(final ScheminoLanguage language) {
        super(language);
    }

    protected ScheminoRootNode(final ScheminoLanguage language, final FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }

    public abstract Object execute(final VirtualFrame virtualFrame);

    public long executeLong(final VirtualFrame virtualFrame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectLong(execute(virtualFrame));
    }

    public boolean executeBoolean(final VirtualFrame virtualFrame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectBoolean(execute(virtualFrame));
    }

    public ScheminoList<?> executeList(final VirtualFrame virtualFrame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectScheminoList(execute(virtualFrame));
    }
}
