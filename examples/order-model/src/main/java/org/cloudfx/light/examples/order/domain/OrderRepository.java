package org.cloudfx.light.examples.order.domain;

import org.cloudfx.light.core.AggregateRootRepository;
import org.cloudfx.light.core.DomainEventPublisher;

import static org.cloudfx.light.examples.order.domain.Order.OrderRefNo;

public abstract class OrderRepository extends AggregateRootRepository<Order, OrderRefNo> {
    public OrderRepository(DomainEventPublisher publisher) {
        super(publisher);
    }
}
