package com.albertoventurini.schemino.truffle.nodes;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
//import com.albertoventurini.schemino.truffle.functions.AddFunction;
import com.albertoventurini.schemino.truffle.nodes.root.AddNode;
import com.albertoventurini.schemino.truffle.types.ScheminoFunction;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;

/**
 * The root node of a Schemino program.
 */
public class ProgramNode extends ExpressionNode {

    private ScheminoLanguage language;
    /**
     * The expressions that make up the program
     */
    @Children private ExpressionNode[] expressions;

    public ProgramNode(final ScheminoLanguage language, final ExpressionNode[] expressions) {
        this.language = language;
        this.expressions = expressions;
    }

    @Override
    @ExplodeLoop
    public Object execute(final VirtualFrame frame) {
        System.out.println("BlockNode:executeGeneric");

        installBuiltIns(frame);

        if (expressions.length == 0) {
            return null;
        }

        for (int i = 0; i < expressions.length - 1; i++) {
            expressions[i].execute(frame);
        }

        return expressions[expressions.length - 1].execute(frame);
    }

    private void installBuiltIns(VirtualFrame frame) {

        ScheminoFunction addFunction = new ScheminoFunction(new AddNode(language));
        final FrameSlot slot = frame.getFrameDescriptor().addFrameSlot("+", FrameSlotKind.Object);
        frame.setObject(slot, addFunction);

//        ScheminoNode node = new ScheminoNode(language, new FrameDescriptor(), new AddNode(null));
//        RootCallTarget callTarget = Truffle.getRuntime().createCallTarget(node);
//
//        //AddFunction addFunction = new AddFunction(callTarget);
//        ScheminoFunction addFunction = new ScheminoFunction(language, "addFunction", new AddNode(null));
//
//        final FrameSlot slot = frame.getFrameDescriptor().addFrameSlot("+", FrameSlotKind.Object);
////        FrameSlot slot = frameDescriptor.addFrameSlot("+", FrameSlotKind.Object);
//        frame.setObject(slot, addFunction);
    }

//    /**
//     * Run the program and return the result of its last expression
//     * @return the result of the last expression in the program
//     */
//    public TypedObject run() {
//        final Frame frame = Frame.root();
//
//        // Set up built-in functions
//        frame.putFunction("+", new AddFunction());
//        frame.putFunction("-", new SubtractFunction());
//        frame.putFunction("==", new EqualsFunction());
//        frame.putFunction("and", new AndFunction());
//        frame.putFunction("quote", new QuoteFunction());
//        frame.putFunction("if", new IfFunction());
//        frame.putFunction("cond", new CondFunction());
//        frame.putFunction(">", new GreaterThanFunction());
//        frame.putFunction("<", new LessThanFunction());
//        frame.putFunction("print", new PrintFunction());
//        frame.putFunction("car", new CarFunction());
//        frame.putFunction("cdr", new CdrFunction());
//        frame.putFunction("append", new AppendFunction());
//        frame.putFunction("size", new SizeFunction());
//        frame.putFunction("fold-left", new FoldLeftFunction());
//
//        return eval(frame);
//    }
//
//    @Override
//    public TypedObject eval(final Frame frame) {
//        for (int i = 0; i < expressions.size() - 1; i++) {
//            expressions.get(i).eval(frame);
//        }
//
//        return expressions.get(expressions.size() - 1).eval(frame);
//    }
}
