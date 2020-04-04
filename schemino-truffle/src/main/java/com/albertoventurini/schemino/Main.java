package com.albertoventurini.schemino;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.IOException;

import static com.albertoventurini.schemino.ScheminoLanguage.ID;

public class Main {
    public static void main( String[] args ) throws IOException {
        final Source source = Source.newBuilder(ID, "(+ 1 2)", "main").build();

        final Context context = Context.newBuilder(ID).build();

        try {
            final Value value = context.eval(source);
            System.out.println("Hello World! The program produced value = " + value);
            System.exit(0);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong...", e);

        } finally {
            context.close();
        }

        System.exit(1);

    }
}
