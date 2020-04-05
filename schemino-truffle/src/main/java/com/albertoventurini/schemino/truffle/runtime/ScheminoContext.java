package com.albertoventurini.schemino.truffle.runtime;

import com.albertoventurini.schemino.truffle.ScheminoLanguage;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.MaterializedFrame;

public final class ScheminoContext {

    private final MaterializedFrame globalFrame;

    public ScheminoContext(final ScheminoLanguage language) {
        globalFrame = Truffle.getRuntime().createMaterializedFrame(null);

        // This is how variables are stored in frames.
        // Here we just inject a test variable in the global frame.
        FrameSlot slot = globalFrame.getFrameDescriptor().addFrameSlot("the-answer");
        globalFrame.setLong(slot, 42);
    }
}
