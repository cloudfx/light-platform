package org.cloudfx.light.examples.infrastructure;

import org.cloudfx.light.examples.domain.Order;
import org.cloudfx.light.examples.domain.Order.OrderItem;
import org.cloudfx.light.examples.domain.Order.OrderRefNo;
import org.cloudfx.light.examples.domain.OrderRepository;

import static java.util.UUID.randomUUID;

public class OrderEndpoints {

    private final OrderRepository repository;

    public OrderEndpoints(OrderRepository repository) {
        this.repository = repository;
    }

    public void createOrder() {
        repository.save(new Order(new OrderRefNo(randomUUID().toString())));
    }

    public void addOrderItem(OrderRefNo refNo, OrderItem orderItem) {
        Order order = repository.get(refNo);
        order.add(orderItem);
        repository.save(order);
    }

    public void completeOrder(OrderRefNo refNo) {
        Order order = repository.get(refNo);
        order.complete();
        repository.save(order);
    }

}
