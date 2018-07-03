package org.cloudfx.light.examples.adapters;


import org.cloudfx.light.examples.domain.Order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static org.cloudfx.light.examples.domain.Order.OrderRefNo;

@Entity
@Table(name = "ORDERS", schema = "order_management")
class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String refNo;

    OrderEntity(String refNo) {
        this.refNo = refNo;
    }

    public OrderEntity(Order order) {

    }

    Order toDomain() {
        return new Order(new OrderRefNo(refNo));
    }
}
