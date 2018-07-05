package org.cloudfx.light.aggregate.examples.order.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class LineItem {

    private final String name;
    private final int quantity;
    private final BigDecimal price;

    public LineItem(String name, BigDecimal price) {
        this(name, 1, price);
    }

}
