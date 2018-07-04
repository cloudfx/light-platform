package org.cloudfx.light.core;

public abstract class AggregateRootRepository<T extends AggregateRoot<ID>, ID> implements Repository<T, ID> {

    private final DomainEventPublisher publisher;

    public AggregateRootRepository(DomainEventPublisher publisher) {
        this.publisher = publisher;
    }

    protected void saveRoot(T root) {
        this.save(this.getOrNew(root.getId()));
        publisher.publish(root.getEvents());
    }
}
