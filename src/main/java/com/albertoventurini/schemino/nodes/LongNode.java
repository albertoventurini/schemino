package com.albertoventurini.schemino.nodes;

import com.albertoventurini.schemino.ScheminoException;
import com.albertoventurini.schemino.ScheminoLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = ScheminoLanguage.ID, description = "A long node")
public class LongNode extends ExpressionNode {

    private final long value;

    public LongNode(final long value) {
        this.value = value;
    }

    @Override
    public Object executeGeneric(final VirtualFrame frame) {
        //return value;
        throw ScheminoException.typeError(this);
    }

    @Override
    public long executeLong(final VirtualFrame virtualFrame) {
        return value;
    }
//
//    @Override
//    public Object execute(VirtualFrame virtualFrame) {
//        return value;
//    }

    @Override
    public String toString() {
        return "LongNode{" +
                "value=" + value +
                '}';
    }

}
