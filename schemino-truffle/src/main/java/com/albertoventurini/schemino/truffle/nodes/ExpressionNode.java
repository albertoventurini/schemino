package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.types.ScheminoTypes;
import com.albertoventurini.schemino.truffle.types.ScheminoTypesGen;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

@TypeSystemReference(ScheminoTypes.class)
@NodeInfo(description = "The abstract base node for all expressions")
public abstract class ExpressionNode extends Node {

    public abstract Object execute(final VirtualFrame frame);

    public long executeLong(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectLong(execute(frame));
    }

    public boolean executeBoolean(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectBoolean(execute(frame));
    }

    public String executeString(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectString(execute(frame));
    }
}
