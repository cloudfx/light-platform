package org.cloudfx.light.core.aggregate;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    private transient List<Object> domainEvents = new ArrayList<>();

    protected <T> void registerEvent(T event) {
        Assert.notNull(event, "Domain event must be not null!");
        this.domainEvents.add(event);
    }

    @SuppressWarnings("WeakerAccess")
    protected List<Object> getDomainEvents() {
        return domainEvents;
    }

    protected void clearDomainEvents() {
        this.domainEvents.clear();
    }

}
