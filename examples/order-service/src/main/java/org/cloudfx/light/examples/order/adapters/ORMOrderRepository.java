package org.cloudfx.light.examples.order.adapters;

import org.cloudfx.light.core.AggregateRootRepository;
import org.cloudfx.light.core.DomainEventPublisher;
import org.cloudfx.light.examples.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.cloudfx.light.examples.order.domain.Order.*;

@Repository
class ORMOrderRepository extends AggregateRootRepository<Order, OrderRefNo> {

    private final DataLayerOrderRepository repository;

    ORMOrderRepository(DataLayerOrderRepository repository, DomainEventPublisher publisher) {
        super(publisher);
        this.repository = repository;
    }

    @Override
    public void save(Order order) {
        this.saveRoot(order);
    }

    @Override
    public Order get(OrderRefNo refNo) {
        return getById(refNo).orElseThrow();
    }

    @Override
    public Order getOrNew(OrderRefNo refNo) {
        return getById(refNo).orElse(new Order(refNo));
    }

    @Override
    public Optional<Order> getById(OrderRefNo refNo) {
        return repository.findByRefNo(refNo.getRefNo()).map(OrderEntity::toDomain);
    }

    interface DataLayerOrderRepository extends JpaRepository<OrderEntity, Long> {
        Optional<OrderEntity> findByRefNo(String refNo);
    }

}
