package com.albertoventurini.schemino.naive;

import java.util.Objects;

public class FrameSlot {

    private String name;

    private Class type;

    public FrameSlot(String name, Class type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Class getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameSlot frameSlot = (FrameSlot) o;
        return Objects.equals(name, frameSlot.name) &&
                Objects.equals(type, frameSlot.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "FrameSlot{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
