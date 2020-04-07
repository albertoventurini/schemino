package com.albertoventurini.schemino.naive.exceptions;

public class InvalidFunction extends ScheminoException {

    public InvalidFunction() {
        super("Invalid function");
    }

    public InvalidFunction(final String functionName) {
        super("Invalid function \"" + functionName + "\"");
    }
}
