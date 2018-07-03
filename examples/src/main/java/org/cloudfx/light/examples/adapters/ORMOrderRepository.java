package org.cloudfx.light.examples.adapters;

import org.cloudfx.light.core.DomainEventPublisher;
import org.cloudfx.light.examples.domain.Order;
import org.cloudfx.light.examples.domain.Order.OrderRefNo;
import org.cloudfx.light.examples.domain.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
class ORMOrderRepository implements OrderRepository {

    private final SpringOrderRepository repository;
    private final DomainEventPublisher publisher;

    ORMOrderRepository(SpringOrderRepository repository, DomainEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @Override
    public void save(Order order) {
        repository.save(repository.findByRefNo(order.getRefNo()).orElse(new OrderEntity(order)));
        publisher.publish(order.getEvents());
    }

    @Override
    public Order get(OrderRefNo refNo) {
        return getById(refNo).orElseThrow();
    }

    @Override
    public Optional<Order> getById(OrderRefNo refNo) {
        return repository.findByRefNo(refNo.getRefNo()).map(OrderEntity::toDomain);
    }

    interface SpringOrderRepository extends JpaRepository<OrderEntity, Long> {

        Optional<OrderEntity> findByRefNo(String refNo);
    }

}
