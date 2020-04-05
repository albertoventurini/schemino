package com.albertoventurini.schemino.naive.exceptions;

public abstract class ScheminoException extends RuntimeException {

    public ScheminoException(final String message) {
        super(message);
    }

    public ScheminoException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
