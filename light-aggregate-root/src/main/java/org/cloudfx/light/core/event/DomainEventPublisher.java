package org.cloudfx.light.core.event;

public interface DomainEventPublisher {
    void publish(Object event);
}
