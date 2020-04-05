package com.albertoventurini.schemino.truffle.parser;

import com.albertoventurini.schemino.truffle.nodes.ScheminoRootNode;

/**
 * Create nodes from the parser output
 */
public interface NodeFactory {
    ScheminoRootNode[] buildNodes();
}
