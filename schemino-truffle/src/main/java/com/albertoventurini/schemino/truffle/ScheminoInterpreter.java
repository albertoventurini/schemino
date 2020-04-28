package com.albertoventurini.schemino.truffle;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.IOException;
import java.nio.file.Path;

public class ScheminoInterpreter {

    public Value call(final String inputFile) throws Exception {
        final Path path = Path.of(inputFile);

        if (!path.toFile().exists()) {
            throw new RuntimeException("File not found: " + inputFile);
        }

        return evaluateProgram(path);
    }

    private static Value evaluateProgram(final Path filePath) throws IOException {
        final Source source = Source.newBuilder(ScheminoLanguage.ID, filePath.toFile()).build();
        final Context context = Context.newBuilder(ScheminoLanguage.ID).build();

        try {
            return context.eval(source);
        } catch (Exception e) {
            throw new RuntimeException("Error", e);
        }
    }
}
