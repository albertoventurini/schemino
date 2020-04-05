package com.albertoventurini.schemino.naive;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains an execution frame, a.k.a. environment.
 * A frame associates each symbol with a value.
 */
public class Frame {

    private final Map<String, Object> frameMap = new HashMap<>();

    public boolean hasSlot(final String slotName) {
        return frameMap.containsKey(slotName);
    }

    public Object get(final String slotName) {
        return frameMap.get(slotName);
    }

    public void put(final String slotName, final Object value) {
        frameMap.put(slotName, value);
    }

}
