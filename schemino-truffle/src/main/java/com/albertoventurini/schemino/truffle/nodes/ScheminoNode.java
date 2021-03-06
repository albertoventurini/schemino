package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
//import com.albertoventurini.schemino.truffle.types.ScheminoTypesGen;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;

//@TypeSystemReference(ScheminoTypes.class)
@NodeInfo(language = "schemino", description = "The root of all nodes")
public class ScheminoNode extends RootNode {
    private ExpressionNode body;

    protected ScheminoNode(final ScheminoLanguage language) {
        super(language);
    }

    public ScheminoNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }

    public ScheminoNode(
            final TruffleLanguage<?> language,
            final FrameDescriptor frameDescriptor,
            final ExpressionNode body) {
        super(language, frameDescriptor);
        this.body = body;
    }

    public Object execute(final VirtualFrame frame) {
        return body.executeGeneric(frame);
    }
//
//    public long executeLong(final VirtualFrame virtualFrame) throws UnexpectedResultException {
//        return ScheminoTypesGen.expectLong(execute(virtualFrame));
//    }
//
//    public boolean executeBoolean(final VirtualFrame virtualFrame) throws UnexpectedResultException {
//        return ScheminoTypesGen.expectBoolean(execute(virtualFrame));
//    }
//
//    public ScheminoList<?> executeList(final VirtualFrame virtualFrame) throws UnexpectedResultException {
//        return ScheminoTypesGen.expectScheminoList(execute(virtualFrame));
//    }
}
