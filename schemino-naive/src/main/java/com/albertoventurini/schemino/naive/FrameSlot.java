package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.types.ScheminoType;

import java.util.Objects;

public class FrameSlot {

    private final ScheminoType type;
    private final Object value;

    public FrameSlot(final ScheminoType type, final Object value) {
        this.type = type;
        this.value = value;
    }

    public ScheminoType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameSlot frameSlot = (FrameSlot) o;
        return Objects.equals(value, frameSlot.value) &&
                Objects.equals(type, frameSlot.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }

    @Override
    public String toString() {
        return "FrameSlot{" +
                "name='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
