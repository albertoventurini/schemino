package com.albertoventurini.schemino.naive.types;

import java.util.List;

public class ScheminoList {

    private final List<TypedObject> items;

    public ScheminoList(final List<TypedObject> items) {
        this.items = items;
    }

    public List<TypedObject> getItems() {
        return items;
    }
}
