package com.albertoventurini.schemino;

import com.albertoventurini.schemino.types.ScheminoList;
import com.oracle.truffle.api.dsl.TypeSystem;

@TypeSystem({long.class, boolean.class, ScheminoList.class})
public abstract class ScheminoTypes {
}
