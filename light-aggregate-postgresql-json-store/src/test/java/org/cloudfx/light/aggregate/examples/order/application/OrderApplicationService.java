package org.cloudfx.light.aggregate.examples.order.application;

import lombok.RequiredArgsConstructor;
import org.cloudfx.light.aggregate.examples.order.domain.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderApplicationService {

    private final OrderRepository orderRepository;


}
