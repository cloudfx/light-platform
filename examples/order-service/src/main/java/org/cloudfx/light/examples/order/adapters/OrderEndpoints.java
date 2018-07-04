package org.cloudfx.light.examples.order.adapters;

import org.cloudfx.light.examples.order.domain.Order;
import org.cloudfx.light.examples.order.domain.Order.OrderRefNo;
import org.cloudfx.light.examples.order.domain.OrderRepository;

import static java.util.UUID.randomUUID;

public class OrderEndpoints {

    private final OrderRepository repository;

    public OrderEndpoints(OrderRepository repository) {
        this.repository = repository;
    }

    public void createOrder() {
        repository.save(new Order(new OrderRefNo(randomUUID().toString())));
    }

    public void addOrderItem(OrderRefNo refNo, Order.OrderItem orderItem) {
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
