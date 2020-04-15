package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.types.TypedObject;
import com.albertoventurini.schemino.parser.ScheminoLexer;
import com.albertoventurini.schemino.parser.ScheminoParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Path;

public class ScheminoInterpreter {

    private final String inputFile;

    public ScheminoInterpreter(final String inputFile) {
        this.inputFile = inputFile;
    }

    public TypedObject call() throws Exception {
        final Path path = Path.of(inputFile);

        if (!path.toFile().exists()) {
            throw new RuntimeException("File not found: " + inputFile);
        }

        return evaluateProgram(path);
    }

    private static TypedObject evaluateProgram(final Path filePath) throws IOException {
        final var lexer = new ScheminoLexer(CharStreams.fromPath(filePath));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        final var node = new NodeFactory().createProgramNode(parser);
        return node.run();
    }
}
