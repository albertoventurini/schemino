package com.albertoventurini.schemino.parser;

import com.albertoventurini.schemino.nodes.ScheminoRootNode;

/**
 * Create nodes from the parser output
 */
public interface NodeFactory {
    ScheminoRootNode[] buildNodes();
}
