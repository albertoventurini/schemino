package com.albertoventurini.schemino.naive;

import com.albertoventurini.schemino.naive.types.TypedObject;
import com.albertoventurini.schemino.parser.ScheminoLexer;
import com.albertoventurini.schemino.parser.ScheminoParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    @Test
    public void fibonacciNaive_shouldWork() throws Exception {
        final String program = Files.readString(Path.of("src/test/resources/fibonacci.sco"));

        final var result = evaluateProgram(program);

        assertEquals(89L, result.getValue());
    }

    @Test
    public void fibonacciLinear_shouldWork() throws Exception {
        final String program = Files.readString(Path.of("src/test/resources/fibonacci-linear.sco"));

        final var result = evaluateProgram(program);

        assertEquals(89L, result.getValue());
    }

    private TypedObject evaluateProgram(final String source) {
        final var lexer = new ScheminoLexer(CharStreams.fromString(source));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        final var node = new NodeFactory().createProgramNode(parser);
        return node.run();
    }
}
