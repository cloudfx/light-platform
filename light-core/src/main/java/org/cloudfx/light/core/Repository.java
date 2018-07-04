package org.cloudfx.light.core;

import java.util.Optional;

public interface Repository<T, ID> {

    void save(T entity);

    T get(ID id);

    Optional<T> getById(ID id);
}
