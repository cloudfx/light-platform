package org.cloudfx.light.core;

import java.util.Optional;

public interface Repository<T extends AggregateRoot, ID> {

    void save(T entity);

    T get(ID id);

    Optional<T> getById(ID id);
}
