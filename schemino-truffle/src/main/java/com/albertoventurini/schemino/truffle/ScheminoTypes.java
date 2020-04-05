package com.albertoventurini.schemino.truffle;

import com.albertoventurini.schemino.truffle.types.ScheminoList;
import com.oracle.truffle.api.dsl.TypeSystem;

@TypeSystem({long.class, boolean.class, ScheminoList.class})
public abstract class ScheminoTypes {
}
