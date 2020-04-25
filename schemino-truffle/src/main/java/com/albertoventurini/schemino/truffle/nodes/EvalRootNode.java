package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

// TODO: understand!
// A root note that can be evaluated?
public class EvalRootNode extends RootNode {
    private ProgramNode programNode;

    public EvalRootNode(final ScheminoLanguage language) {
        super(language);
    }

    private ExpressionNode program = new BlockNode(
            new ExpressionNode[]{
                    new WriteVariableNode(new SymbolNode("the-answer"), new LongNode(42)),
//                    new IfNode(
//                            new BooleanNode(true),
//                            new ReadVariableNode("the-answer"),
//                            new ReadVariableNode("the-wrong-answer")
//                    )
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

    public EvalRootNode(final ScheminoLanguage language, final ProgramNode programNode) {
        super(language);

        this.programNode = programNode;
    }

    @Override
    public Object execute(final VirtualFrame frame) {
//        return program.executeGeneric(frame);
//        return 42L;
        return programNode.execute(frame);
    }
}
