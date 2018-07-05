package org.cloudfx.light.aggregate.examples.order.domain;

public interface OrderRepository {

    Order get(OrderRef ref);

}
