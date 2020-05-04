package com.albertoventurini.schemino.naive.exceptions;

import com.albertoventurini.schemino.naive.arguments.Arguments;

public class TailCall extends RuntimeException {

    public Arguments arguments;

    public TailCall(Arguments arguments) {

        this.arguments = arguments;
    }
}
