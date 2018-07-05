package org.cloudfx.light.core.aggregate;

import java.util.Optional;

public interface IAggregateRootRepository<T extends AggregateRoot<ID>, ID extends Identifier> {

    T save(T root);

    Optional<T> getOne(ID id);

}
