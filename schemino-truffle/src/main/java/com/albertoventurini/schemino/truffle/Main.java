package com.albertoventurini.schemino.truffle;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.IOException;

import static com.albertoventurini.schemino.truffle.ScheminoLanguage.ID;

public class Main {
    public static void main( String[] args ) throws Exception {
        final Source source = Source.newBuilder(ScheminoLanguage.ID, "answer: (if true (+ 1 2 3) (+ 4 5 6))\nanswer", "main").build();

        final Context context = Context.newBuilder(ScheminoLanguage.ID).build();

        try {
            final Value value = context.eval(source);
            System.out.println("Hello World! The program produced value = " + value);
            System.exit(0);
        } finally {
            context.close();
        }

        System.exit(1);

    }
}
