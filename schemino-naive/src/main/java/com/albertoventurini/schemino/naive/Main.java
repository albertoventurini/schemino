package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.types.TypedObject;
import com.albertoventurini.schemino.parser.ScheminoLexer;
import com.albertoventurini.schemino.parser.ScheminoParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(final String[] args) {

        final Path path = Path.of(args[0]);

        if (!path.toFile().exists()) {
            System.out.println("File doesn't exist");
            System.exit(1);
        }

        try {
            final TypedObject result = evaluateProgram(path);
            System.out.println(result.getValue());
            System.exit(0);
        } catch (IOException e) {
            System.out.println("An error occurred reading the program");
            System.exit(1);
        }
    }

    private static TypedObject evaluateProgram(final Path filePath) throws IOException {
        final var lexer = new ScheminoLexer(CharStreams.fromPath(filePath));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        final var node = new NodeFactory().createProgramNode(parser);
        return node.run();
    }

}
