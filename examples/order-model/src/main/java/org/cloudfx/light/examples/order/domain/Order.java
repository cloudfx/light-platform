package org.cloudfx.light.examples.order.domain;

import org.cloudfx.light.core.AggregateRoot;
import org.cloudfx.light.core.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class Order extends AggregateRoot<Order.OrderRefNo> {

    private final OrderRefNo refNo;
    private final List<OrderItem> orderItems = new ArrayList<>();
    private OrderStatus status;

    public Order(OrderRefNo refNo) {
        this.refNo = refNo;
        this.status = OrderStatus.UNDER_PROCESS;
    }

    public void add(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void complete() {
        this.status = OrderStatus.COMPLETED;
        registerEvent(new OrderCompleted());
    }

    @Override
    public OrderRefNo getId() {
        return refNo;
    }

    public String getRefNo() {
        return refNo.getRefNo();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public enum OrderStatus {
        UNDER_PROCESS, COMPLETED;
    }

    public static class OrderRefNo {
        private final String refNo;

        public OrderRefNo(String refNo) {
            this.refNo = refNo;
        }

        public String getRefNo() {
            return refNo;
        }

    }

    public static class OrderItem {

    }

    public class OrderCompleted implements DomainEvent {

    }
}
