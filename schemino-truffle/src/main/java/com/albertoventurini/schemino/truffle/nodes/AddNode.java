package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoException;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(shortName = "+")
@NodeChild("leftNode")
@NodeChild("rightNode")
public abstract class AddNode extends ExpressionNode {

    @Specialization
    protected long add(final long left, final long right) {
        return left + right;
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        throw ScheminoException.typeError(this);
    }
}
