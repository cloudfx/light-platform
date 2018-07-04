package org.cloudfx.light.core;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot<ID> {

    private final List<DomainEvent> events = new ArrayList<>();

    public abstract ID getId();

    protected void registerEvent(DomainEvent event) {
        events.add(event);
    }

    List<DomainEvent> getEvents() {
        return events;
    }

}
