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

    private final Map<String, FrameSlot> frameMap = new HashMap<>();

    public boolean hasSlot(final String slotName) {
        return frameMap.containsKey(slotName);
    }

    public FrameSlot getSlot(final String slotName) {
        return frameMap.get(slotName);
    }

    public TypedObject getObject(final String slotName) {
        final FrameSlot slot = frameMap.get(slotName);
        return new TypedObject(slot.getType(), slot.getValue());
    }

    public long getLong(final String slotName) {
        final FrameSlot slot = frameMap.get(slotName);

        if (slot == null) {
            throw new FrameSlotNotFound(slotName);
        } else if (slot.getType() != ScheminoType.LONG) {
            throw new TypeMismatch(ScheminoType.LONG, slot.getType());
        }

        return (long) slot.getValue();
    }

    public ScheminoFunction getFunction(final String slotName) {
        final FrameSlot slot = frameMap.get(slotName);

        if (slot == null) {
            throw new FrameSlotNotFound(slotName);
        } else if (slot.getType() != ScheminoType.FUNCTION) {
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
