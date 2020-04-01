package com.albertoventurini.schemino.nodes;

import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;

@NodeInfo(language = "schemino", description = "The root of all execution trees")
public abstract class RootNode extends Node {
}
