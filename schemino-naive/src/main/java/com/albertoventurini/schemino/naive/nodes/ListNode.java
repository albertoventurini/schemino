package com.albertoventurini.schemino.naive.nodes;

import com.albertoventurini.schemino.naive.Frame;
import com.albertoventurini.schemino.naive.functions.UserFunction;
import com.albertoventurini.schemino.naive.types.ScheminoType;
import com.albertoventurini.schemino.naive.types.TypedObject;

import java.util.List;

public class ListNode extends ExpressionNode {


    private List<ExpressionNode> items;

    public ListNode(final List<ExpressionNode> items) {

        this.items = items;
    }

    @Override
    public TypedObject eval(final Frame frame) {
        if (items.isEmpty()) {
            return new TypedObject(ScheminoType.LIST, items);
        }

        final Object firstItemEval = items.get(0).eval(frame);

        if (firstItemEval instanceof String) {
            final String firstItemLabel = (String) firstItemEval;
            if (frame.hasSlot(firstItemLabel)) {
                frame.getObject(firstItemLabel);
            }
        }

        return null;
    }

    private Object callFunction(final UserFunction function, final List<ExpressionNode> arguments) {
        // todo:
        // - inject arguments into function's frame (perhaps by re-using WriteVariableNode's)
        // -
        return null;
    }

}
