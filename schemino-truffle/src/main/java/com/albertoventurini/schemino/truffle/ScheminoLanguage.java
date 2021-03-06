package com.albertoventurini.schemino.truffle;

import com.albertoventurini.schemino.parser.ScheminoLexer;
import com.albertoventurini.schemino.parser.ScheminoParser;
import com.albertoventurini.schemino.truffle.nodes.EvalRootNode;
import com.albertoventurini.schemino.truffle.nodes.ProgramNode;
import com.albertoventurini.schemino.truffle.parser.NodeFactory;
import com.albertoventurini.schemino.truffle.runtime.ScheminoContext;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.nodes.ExecutableNode;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import static com.albertoventurini.schemino.truffle.ScheminoLanguage.ID;
import static com.albertoventurini.schemino.truffle.ScheminoLanguage.MIME_TYPE;

@TruffleLanguage.Registration(id = ID, name = "Schemino", version = "0.1.0",
        characterMimeTypes = MIME_TYPE, defaultMimeType = MIME_TYPE)
public final class ScheminoLanguage extends TruffleLanguage<ScheminoContext> {

    public static final String ID = "schemino";
    public static final String MIME_TYPE = "application/x-schemino";

    private FrameDescriptor frameDescriptor = new FrameDescriptor();
    private MaterializedFrame globalFrame = Truffle.getRuntime().createMaterializedFrame(null);

    @Override
    protected ScheminoContext createContext(final Env env) {
//        MaterializedFrame frame = Truffle.getRuntime().createMaterializedFrame(null);
        return new ScheminoContext(this, globalFrame);
    }

    @Override
    protected boolean isObjectOfLanguage(final Object object) {
        return false;
    }

    @Override
    protected CallTarget parse(final ParsingRequest request) throws Exception {
        final ProgramNode programNode = createProgramNode(request.getSource().getCharacters().toString());
        return Truffle.getRuntime().createCallTarget(new EvalRootNode(this, programNode, globalFrame.getFrameDescriptor()));
    }

    @Override
    protected ExecutableNode parse(final InlineParsingRequest request) throws Exception {
        return super.parse(request);
    }

    private ProgramNode createProgramNode(final String source) {
        final var lexer = new ScheminoLexer(CharStreams.fromString(source));
        final var tokenStream = new CommonTokenStream(lexer);
        final var parser = new ScheminoParser(tokenStream);

        return new NodeFactory(this).createProgramNode(parser);
    }
}
