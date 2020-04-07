package com.albertoventurini.schemino.naive.types;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.nodes.ExpressionNode;

import java.util.List;

public interface ScheminoFunction {
    TypedObject apply(Frame frame, List<ExpressionNode> arguments);
}
