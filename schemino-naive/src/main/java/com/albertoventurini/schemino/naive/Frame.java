package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.exceptions.FrameSlotNotFound;
import com.albertoventurini.schemino.naive.exceptions.TypeMismatch;
import com.albertoventurini.schemino.naive.types.ScheminoFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains an execution frame, a.k.a. environment.
 * A frame associates each symbol with a value.
 */
public class Frame {

    /**
     * A map from slot names to slots
     */
    private final Map<String, FrameSlot> frameMap = new HashMap<>();

    /**
     * The parent frame (null for the root frame)
     */
    private final Frame parentFrame;

    private Frame(final Frame parentFrame) {
        this.parentFrame = parentFrame;
    }

    /**
     * Create a new root frame. This is the holder of global variables.
     * @return a new frame
     */
    public static Frame root() {
        return new Frame(null);
    }

    /**
     * Create a new local frame.
     * @param parentFrame the parent frame
     * @return a new frame
     */
    public static Frame fromParent(final Frame parentFrame) {
        return new Frame(parentFrame);
    }

    // Attempt to find the slot in the frame hierarchy, starting from the bottom (this frame).
    // Keep traversing the frame hierarchy until either the slot is found or we've reached the top.
    private FrameSlot resolveSlot(final String slotName) {
        Frame frame = this;
        while (frame != null) {
            if (frame.frameMap.containsKey(slotName)) {
                return frame.frameMap.get(slotName);
            }
            frame = frame.parentFrame;
        }
        return null;
    }

    // Attempt to find the slot in the frame hierarchy.
    // If it's not found, throw an exception.
    private FrameSlot resolveSlotOrThrow(final String slotName) {
        final FrameSlot slot = resolveSlot(slotName);
        if (slot == null) {
            throw new FrameSlotNotFound(slotName);
        }
        return slot;
    }

    public boolean hasSlot(final String slotName) {
        return resolveSlot(slotName) != null;
    }

    public FrameSlot getSlot(final String slotName) {
        return resolveSlot(slotName);
    }

    public TypedObject getObject(final String slotName) {
        final FrameSlot slot = resolveSlotOrThrow(slotName);
        return new TypedObject(slot.getType(), slot.getValue());
    }

    /**
     * Find the slot identified by `slotName` and return its long value.
     * If the slot type is not long, throw an exception.
     *
     * @param slotName the slot name
     * @return the slot value, as a long
     * @throws TypeMismatch if the slot type is not long
     */
    public long getLong(final String slotName) {
        final FrameSlot slot = resolveSlotOrThrow(slotName);

        if (slot.getType() != ScheminoType.LONG) {
            throw new TypeMismatch(ScheminoType.LONG, slot.getType());
        }

        return (long) slot.getValue();
    }

    /**
     * Find the slot identified by `slotName` and return its ScheminoFunction value.
     * If the slot type is not ScheminoFunction, throw an exception.
     *
     * @param slotName the slot name
     * @return the slot value, as a ScheminoFunction
     * @throws TypeMismatch if the slot type is not ScheminoFunction
     */
    public ScheminoFunction getFunction(final String slotName) {
        final FrameSlot slot = resolveSlotOrThrow(slotName);

        if (slot.getType() != ScheminoType.FUNCTION) {
            throw new TypeMismatch(ScheminoType.FUNCTION, slot.getType());
        }

        return (ScheminoFunction) slot.getValue();
    }

    public void putObject(final String slotName, final TypedObject typedObject) {
        frameMap.put(slotName, new FrameSlot(typedObject.getType(), typedObject.getValue()));
    }

    public void putLong(final String slotName, final long value) {
        frameMap.put(slotName, new FrameSlot(ScheminoType.LONG, value));
    }

    public void putFunction(final String slotName, final ScheminoFunction value) {
        frameMap.put(slotName, new FrameSlot(ScheminoType.FUNCTION, value));
    }

}
