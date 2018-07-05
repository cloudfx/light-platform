package org.cloudfx.light.aggregate.examples.payment.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.cloudfx.light.aggregate.examples.order.domain.OrderRef;

@EqualsAndHashCode
@ToString
@Getter
public class OrderPaid {

    private OrderRef ref;

    public OrderPaid(OrderRef ref) {
        this.ref = ref;
    }

}
