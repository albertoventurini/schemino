package com.albertoventurini.schemino.naive.types;

import com.albertoventurini.schemino.naive.exceptions.TypeMismatch;

import java.util.Objects;

/** This class represents an object with a specific type */
public class TypedObject {

    /** The type of the object */
    private final ScheminoType type;

    /** The value of the object */
    private final Object value;

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

    public static TypedObject ofLong(final long value) {
        return new TypedObject(ScheminoType.LONG, value);
    }

    public long getLongOrThrow() {
        if (type != ScheminoType.LONG) {
            throw new TypeMismatch(ScheminoType.LONG, type);
        }
        return (long) value;
    }

    public boolean getBooleanOrThrow() {
        if (type != ScheminoType.BOOLEAN) {
            throw new TypeMismatch(ScheminoType.BOOLEAN, type);
        }
        return (boolean) value;
    }

    public ScheminoFunction getFunctionOrThrow() {
        if (type != ScheminoType.FUNCTION) {
            throw new TypeMismatch(ScheminoType.FUNCTION, type);
        }
        return (ScheminoFunction) value;
    }

    public ScheminoList getListOrThrow() {
        if (type != ScheminoType.LIST) {
            throw new TypeMismatch(ScheminoType.LIST, type);
        }
        return (ScheminoList) value;
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
