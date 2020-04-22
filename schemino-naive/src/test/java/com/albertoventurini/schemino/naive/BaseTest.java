package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.types.TypedObject;
import com.albertoventurini.schemino.parser.ScheminoLexer;
import com.albertoventurini.schemino.parser.ScheminoParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class BaseTest {

    protected TypedObject evaluateProgram(final String source) {
        final var lexer = new ScheminoLexer(CharStreams.fromString(source));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        final var node = new NodeFactory().createProgramNode(parser);
        return node.run();
    }

    protected TypedObject evaluateProgram(final Path path) {
        try {
            final String source = Files.readString(path);
            return evaluateProgram(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
