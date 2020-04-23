package com.albertoventurini.schemino.naive.types;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The list type for Schemino.
 */
public class ScheminoList {

    /**
     * The items contained in the list.
     */
    private final List<TypedObject> items;

    public ScheminoList(final List<TypedObject> items) {
        this.items = items;
    }

    public List<TypedObject> getItems() {
        return items;
    }

    public TypedObject get(final int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheminoList that = (ScheminoList) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return "(" + items.stream().map(TypedObject::toString).collect(Collectors.joining(" ")) + ")";
    }
}
