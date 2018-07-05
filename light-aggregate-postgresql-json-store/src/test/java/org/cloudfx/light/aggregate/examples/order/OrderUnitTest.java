package org.cloudfx.light.aggregate.examples.order;

import org.cloudfx.light.aggregate.examples.order.domain.LineItem;
import org.cloudfx.light.aggregate.examples.order.domain.Location;
import org.cloudfx.light.aggregate.examples.order.domain.Order;
import org.cloudfx.light.aggregate.examples.order.domain.Order.Status;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderUnitTest {

    @Test
    void for_new_order_payment_is_expected() {
        Order order = new Order(new Location(), new LineItem("Milk", BigDecimal.TEN));
        assertEquals(Status.PAYMENT_EXPECTED, order.getStatus());
    }

    @Test
    void customer_paid_the_payment() {
        Order order = new Order(new Location(), new LineItem("", BigDecimal.TEN));
    }
}