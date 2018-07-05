package org.cloudfx.light.core.aggregate;

import org.cloudfx.light.core.event.DomainEventPublisher;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

public abstract class AggregateRootRepository<T extends AggregateRoot<ID>, ID extends Identifier> implements IAggregateRootRepository<T, ID> {

    private DomainEventPublisher publisher;

    /**
     * Save aggregate root on the store
     *
     * @param root
     * @return
     */
    public T save(T root) {
        Assert.notNull(root, "Aggregate root must be not null");
        Optional<T> one = this.getOne(root.identity());
        List<Object> events = root.getDomainEvents();
        T save = one.map(current -> this.updateToDataLayer(current, root)).orElse(this.saveToDataLayer(root));
        events.forEach(publisher::publish);
        root.clearDomainEvents();
        return save;
    }


    public abstract Optional<T> getOne(ID id);

    @SuppressWarnings("WeakerAccess")
    protected abstract T saveToDataLayer(T root);

    @SuppressWarnings("WeakerAccess")
    protected abstract T updateToDataLayer(T current, T update);

    public void setPublisher(DomainEventPublisher publisher) {
        this.publisher = publisher;
    }

}
