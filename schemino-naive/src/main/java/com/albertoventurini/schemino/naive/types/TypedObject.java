package com.albertoventurini.schemino.naive.types;

import java.util.Objects;

/**
 * This class represents an object with a specific type.
 */
public class TypedObject {

    private ScheminoType type;
    private Object value;

    public TypedObject(final ScheminoType type, final Object value) {
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
        TypedObject that = (TypedObject) o;
        return type == that.type &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        return "TypedObject{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
