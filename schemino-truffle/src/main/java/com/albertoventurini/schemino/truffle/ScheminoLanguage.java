package com.albertoventurini.schemino.truffle;

import com.albertoventurini.schemino.truffle.nodes.EvalRootNode;
import com.albertoventurini.schemino.truffle.runtime.ScheminoContext;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.nodes.ExecutableNode;

import static com.albertoventurini.schemino.truffle.ScheminoLanguage.ID;
import static com.albertoventurini.schemino.truffle.ScheminoLanguage.MIME_TYPE;

@TruffleLanguage.Registration(id = ID, name = "Schemino", version = "0.1.0", characterMimeTypes = MIME_TYPE, defaultMimeType = MIME_TYPE)
public final class ScheminoLanguage extends TruffleLanguage<ScheminoContext> {

    public static final String ID = "schemino";
    public static final String MIME_TYPE = "application/x-schemino";

    @Override
    protected ScheminoContext createContext(final Env env) {
        return null;
    }

    @Override
    protected boolean isObjectOfLanguage(final Object object) {
        return false;
    }

    @Override
    protected CallTarget parse(final ParsingRequest request) throws Exception {
        return Truffle.getRuntime().createCallTarget(new EvalRootNode(this));
    }

    @Override
    protected ExecutableNode parse(InlineParsingRequest request) throws Exception {
        return super.parse(request);
    }
}
