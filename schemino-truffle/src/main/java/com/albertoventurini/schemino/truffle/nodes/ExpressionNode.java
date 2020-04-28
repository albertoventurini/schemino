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

    public ScheminoFunction executeFunction(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectScheminoFunction(execute(frame));
    }

    public ScheminoList executeList(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectScheminoList(execute(frame));
    }

    public ScheminoDictionary executeDictionary(final VirtualFrame frame) throws UnexpectedResultException {
        return ScheminoTypesGen.expectScheminoDictionary(execute(frame));
    }
}
