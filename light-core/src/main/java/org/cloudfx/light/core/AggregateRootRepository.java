package org.cloudfx.light.core;

public abstract class AggregateRootRepository<T extends AggregateRoot<ID>, ID> implements Repository<T, ID> {

    private final DomainEventPublisher publisher;

    public AggregateRootRepository(DomainEventPublisher publisher) {
        this.publisher = publisher;
    }

    protected void saveAggregateRoot(T root) {
        this.saveToDataLayer(root);
        publisher.publish(root.getEvents());
    }

    protected abstract void saveToDataLayer(T root);
}
