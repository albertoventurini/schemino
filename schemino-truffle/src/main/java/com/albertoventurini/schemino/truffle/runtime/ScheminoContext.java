package com.albertoventurini.schemino.truffle.runtime;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.oracle.truffle.api.frame.MaterializedFrame;

public final class ScheminoContext {

//    private final MaterializedFrame globalFrame;
    private final ScheminoLanguage language;
//    private FrameDescriptor frameDescriptor;

    public ScheminoContext(final ScheminoLanguage language, final MaterializedFrame globalFrame) {
        this.language = language;
//        this.globalFrame = globalFrame;
        //globalFrame = Truffle.getRuntime().createMaterializedFrame(null);

        // This is how variables are stored in frames.
        // Here we just inject a test variable in the global frame.
        //FrameSlot slot = globalFrame.getFrameDescriptor().addFrameSlot("the-answer");
        //globalFrame.setLong(slot, 42);

//        installBuiltIns();
    }

    public ScheminoLanguage getLanguage() {
        return language;
    }

//    private void installBuiltIns() {
//        ScheminoNode node = new ScheminoNode(language, new FrameDescriptor(), new AddNode(null));
//        RootCallTarget callTarget = Truffle.getRuntime().createCallTarget(node);
//
//        AddFunction addFunction = new AddFunction(callTarget);
//
//        final FrameSlot slot = globalFrame.getFrameDescriptor().addFrameSlot("+", FrameSlotKind.Object);
////        FrameSlot slot = frameDescriptor.addFrameSlot("+", FrameSlotKind.Object);
//        globalFrame.setObject(slot, addFunction);
//    }
}
