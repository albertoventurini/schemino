package com.albertoventurini.schemino.naive.exceptions;

public class UnknownSymbol extends ScheminoException {

    public UnknownSymbol(final String symbolName) {
        super("Unknown symbol: " + symbolName);
    }
}
