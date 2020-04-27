package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class RootAddNode extends RootNode {


    public RootAddNode(ScheminoLanguage language) {

        super(language);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        Object[] arguments = (Object[]) frame.getArguments()[1];

        long sum = 0;

        for (int i = 0; i < arguments.length; i++) {
            sum += (long) arguments[i];
        }

        return sum;
    }
}
