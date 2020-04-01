package com.albertoventurini.schemino;

import com.albertoventurini.schemino.runtime.ScheminoContext;
import com.oracle.truffle.api.TruffleLanguage;

import static com.albertoventurini.schemino.ScheminoLanguage.ID;
import static com.albertoventurini.schemino.ScheminoLanguage.MIME_TYPE;

@TruffleLanguage.Registration(id = ID, name = "Schemino", version = "0.0.1", characterMimeTypes = MIME_TYPE, defaultMimeType = MIME_TYPE)
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
}
