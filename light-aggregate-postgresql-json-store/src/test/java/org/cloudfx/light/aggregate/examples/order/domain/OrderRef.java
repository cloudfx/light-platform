package org.cloudfx.light.aggregate.examples.order.domain;

import org.cloudfx.light.core.aggregate.Identifier;

public class OrderRef implements Identifier {


    public static OrderRef nextRef() {
        return null;
    }

    @Override
    public boolean isValid() {
        return false;
    }
}
