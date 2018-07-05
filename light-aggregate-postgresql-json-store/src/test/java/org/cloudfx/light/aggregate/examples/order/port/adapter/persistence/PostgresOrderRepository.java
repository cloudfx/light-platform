package org.cloudfx.light.aggregate.examples.order.port.adapter.persistence;

import lombok.RequiredArgsConstructor;
import org.cloudfx.light.aggregate.examples.order.domain.Order;
import org.cloudfx.light.aggregate.examples.order.domain.OrderRef;
import org.cloudfx.light.aggregate.examples.order.domain.OrderRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostgresOrderRepository implements OrderRepository {

    private final PostgresOrderRepository repository;

    @Override
    public Order get(OrderRef ref) {
        return null;
    }


    interface PostgreSQLOrderRepository extends PagingAndSortingRepository<Order, OrderRef> {

    }

}
