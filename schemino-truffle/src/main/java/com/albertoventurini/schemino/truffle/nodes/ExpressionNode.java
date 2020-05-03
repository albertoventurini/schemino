package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.types.ScheminoDictionary;
import com.albertoventurini.schemino.truffle.types.ScheminoFunction;
import com.albertoventurini.schemino.truffle.types.ScheminoList;
import com.albertoventurini.schemino.truffle.types.ScheminoTypes;
import com.albertoventurini.schemino.truffle.types.ScheminoTypesGen;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

@TypeSystemReference(ScheminoTypes.class)
@NodeInfo(description = "The abstract base node for all expressions")
public abstract class ExpressionNode extends Node {

    public abstract Object executeGeneric(final VirtualFrame frame);

    public long executeLong(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectLong(executeGeneric(frame));
    }

    public boolean executeBoolean(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectBoolean(executeGeneric(frame));
    }

    public String executeString(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectString(executeGeneric(frame));
    }

    public ScheminoFunction executeFunction(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectScheminoFunction(executeGeneric(frame));
    }

    public ScheminoList executeList(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectScheminoList(executeGeneric(frame));
    }

    public ScheminoDictionary executeDictionary(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectScheminoDictionary(executeGeneric(frame));
    }
}
