package org.cloudfx.light.aggregate.examples.order.domain;

import lombok.Getter;
import org.cloudfx.light.aggregate.examples.payment.domain.OrderPaid;
import org.cloudfx.light.core.aggregate.AggregateRoot;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "orders", schema = "order_management")
public class Order extends AggregateRoot<OrderRef> implements Identifiable<OrderRef> {

    @Id
    private final OrderRef orderRef;

    private final LocalDateTime orderedDate;
    private final Location location;
    private final List<LineItem> lineItems = new ArrayList<>();
    @Getter
    private Status status;

    /**
     * Create a {@link Order} for given {@link LineItem}s and {@link Location}
     *
     * @param lineItems must not be {@literal null}
     * @param location
     */
    public Order(List<LineItem> lineItems, Location location) {
        this.orderRef = OrderRef.nextRef();
        this.location = location;
        this.lineItems.addAll(lineItems);
        this.orderedDate = LocalDateTime.now();
        this.status = Status.PAYMENT_EXPECTED;
    }

    public Order(Location location, LineItem... lineItems) {
        this(Arrays.asList(lineItems), location);
    }

    /**
     * Marks the {@link Order} as payed.
     */
    public Order markPaid() {

        if (isPaid()) {
            throw new IllegalStateException("Already paid order cannot be paid again!");
        }

        this.status = Status.PAID;

        registerEvent(new OrderPaid(identity()));

        return this;
    }

    /**
     * Returns whether the {@link Order} has been paid already.
     *
     * @return
     */
    public boolean isPaid() {
        return !this.status.equals(Status.PAYMENT_EXPECTED);
    }

    @Override
    public OrderRef getId() {
        return identity();
    }

    public enum Status {
        /**
         * Placed, but not payed yet. Still changeable.
         */
        PAYMENT_EXPECTED,

        /**
         * {@link Order} was payed. No changes allowed to it anymore.
         */
        PAID,

        /**
         * The {@link Order} is currently processed.
         */
        PREPARING,

        /**
         * The {@link Order} is ready to be picked up by the customer.
         */
        READY,

        /**
         * The {@link Order} was completed.
         */
        TAKEN;

    }

}
