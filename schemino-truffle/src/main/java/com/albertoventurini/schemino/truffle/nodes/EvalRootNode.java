package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

// TODO: understand!
// A root note that can be evaluated?
public class EvalRootNode extends RootNode {
    public EvalRootNode(final ScheminoLanguage language) {
        super(language);
    }

    private ExpressionNode program = new BlockNode(
            new ExpressionNode[]{
                    new WriteVariableNode("the-answer", 42),
                    new IfNode(
                            new BooleanNode(true),
                            new ReadVariableNode("the-answer"),
                            new ReadVariableNode("the-wrong-answer")
                    )
            }
    );

//    private ExpressionNode ifChild = new IfNode(
//            new BooleanNode(false),
//            AddNodeGen.create(
//                    new LongNode(1),
//                    new LongNode(41)
//            ),
//            ReadVariableNodeGen.create("the-answer")
//    );

    protected EvalRootNode(final ScheminoLanguage language, final FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }

    @Override
    public Object execute(final VirtualFrame frame) {

        // Just testing. Inject a variable in the current frame, which is then passed down to all the children.
//        FrameSlot slot = frame.getFrameDescriptor().addFrameSlot("the-answer", FrameSlotKind.Long);
//        frame.setLong(slot, 42);
//
//        return ifChild.executeGeneric(frame);

        return program.executeGeneric(frame);
    }
}