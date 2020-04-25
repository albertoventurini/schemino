package com.albertoventurini.schemino.truffle.types;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;

import java.util.List;
import java.util.Objects;

/**
 * The list type for Schemino.
 */
@ExportLibrary(InteropLibrary.class)
public class ScheminoList implements TruffleObject {

    /**
     * The items contained in the list.
     */
    private final List<Object> items;

    public ScheminoList(final List<Object> items) {
        this.items = items;
    }

    public List<Object> getItems() {
        return items;
    }

    public Object get(final int index) {
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
        return "ScheminoList{" +
                "items=" + items +
                '}';
    }
}
