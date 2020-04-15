package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.types.TypedObject;

public class Main {

    public static void main(final String[] args) {
        final var interpreter = new ScheminoInterpreter(args[0]);

        try {
            final TypedObject result = interpreter.call();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
