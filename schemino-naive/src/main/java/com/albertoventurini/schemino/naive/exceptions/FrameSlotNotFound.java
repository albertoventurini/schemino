package com.albertoventurini.schemino.naive.exceptions;

public class FrameSlotNotFound extends ScheminoException {
    public FrameSlotNotFound(final String frameSlotName) {
        super("Frame slot not found for name \"" + frameSlotName + "\"");
    }
}
