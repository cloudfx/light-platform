package org.cloudfx.light.examples.order.domain;

import org.cloudfx.light.core.AggregateRootRepository;
import org.cloudfx.light.core.DomainEventPublisher;

public abstract class OrderRepository extends AggregateRootRepository<Order, Order.OrderRefNo> {
    public OrderRepository(DomainEventPublisher publisher) {
        super(publisher);
    }
}
