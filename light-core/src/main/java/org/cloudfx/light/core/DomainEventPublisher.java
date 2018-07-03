package org.cloudfx.light.core;

import java.util.List;

@FunctionalInterface
public interface DomainEventPublisher {

    void publish(List<DomainEvent> events);

}
