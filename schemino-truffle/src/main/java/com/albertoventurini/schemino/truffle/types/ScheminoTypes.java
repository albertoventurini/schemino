package com.albertoventurini.schemino.truffle.types;

import com.oracle.truffle.api.dsl.TypeSystem;

@TypeSystem({long.class, boolean.class, String.class, ScheminoList.class, ScheminoFunction.class})
public abstract class ScheminoTypes {
}
