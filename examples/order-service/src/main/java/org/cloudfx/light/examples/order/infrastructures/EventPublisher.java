package org.cloudfx.light.examples.order.infrastructures;

import org.cloudfx.light.core.DomainEvent;
import org.cloudfx.light.core.DomainEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class EventPublisher implements DomainEventPublisher {

    @Override
    public void publish(List<DomainEvent> events) {

    }

}
