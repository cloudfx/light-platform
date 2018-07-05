package org.cloudfx.light.aggregate.examples.payment.domain;


import org.cloudfx.light.aggregate.examples.order.domain.Order;

public interface PaymentService {

    void pay(Order order, CreditCardNumber creditCardNumber);
}
