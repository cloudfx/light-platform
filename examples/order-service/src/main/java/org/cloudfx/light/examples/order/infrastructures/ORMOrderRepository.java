package org.cloudfx.light.examples.order.infrastructures;

import org.cloudfx.light.core.DomainEventPublisher;
import org.cloudfx.light.examples.order.domain.Order;
import org.cloudfx.light.examples.order.domain.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.cloudfx.light.examples.order.domain.Order.OrderRefNo;

@Repository
class ORMOrderRepository extends OrderRepository {

    private final DataLayerOrderRepository repository;

    ORMOrderRepository(DataLayerOrderRepository repository, DomainEventPublisher publisher) {
        super(publisher);
        this.repository = repository;
    }

    @Override
    public void save(Order order) {
        super.saveAggregateRoot(order);
    }

    @Override
    public Order get(OrderRefNo refNo) {
        return getById(refNo).orElseThrow();
    }

    @Override
    public Optional<Order> getById(OrderRefNo refNo) {
        return repository.findByRefNo(refNo.getRefNo()).map(OrderEntity::toDomain);
    }

    @Override
    protected void saveToDataLayer(Order root) {
        repository.save(new OrderEntity(root));
    }

    interface DataLayerOrderRepository extends JpaRepository<OrderEntity, Long> {
        Optional<OrderEntity> findByRefNo(String refNo);
    }

}
