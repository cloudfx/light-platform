package org.cloudfx.light.examples.adapters;

import org.cloudfx.light.core.DomainEvent;
import org.cloudfx.light.core.DomainEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class KafkaOrderEvents implements DomainEventPublisher {

    @Override
    public void publish(List<DomainEvent> events) {

    }


}
