package org.cloudfx.light.core.aggregate;

import static java.util.Objects.nonNull;

public abstract class Entity<ID extends Identifier> implements Identifiable<ID> {

    private ID identity;

    @Override
    public ID identity() {
        return this.identity;
    }

    @Override
    public void identity(ID identity) {
        this.identity = identity;
    }

    @Override
    public boolean isIdentified() {
        return nonNull(identity) && identity.isValid();
    }

    @Override
    public boolean isUnidentified() {
        return !isIdentified();
    }

}
