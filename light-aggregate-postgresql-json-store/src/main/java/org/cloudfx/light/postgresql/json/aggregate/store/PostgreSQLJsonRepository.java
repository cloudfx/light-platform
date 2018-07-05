package org.cloudfx.light.postgresql.json.aggregate.store;

import org.cloudfx.light.core.aggregate.AggregateRoot;
import org.cloudfx.light.core.aggregate.AggregateRootRepository;
import org.cloudfx.light.core.aggregate.Identifier;

import java.util.Optional;

public abstract class PostgreSQLJsonRepository<T extends AggregateRoot<ID>, ID extends Identifier> extends AggregateRootRepository<T, ID> {

    @Override
    public Optional<T> getOne(ID id) {
        return Optional.empty();
    }

    @Override
    protected T saveToDataLayer(T root) {
        return null;
    }

    @Override
    protected T updateToDataLayer(T current, T update) {
        return null;
    }
}
