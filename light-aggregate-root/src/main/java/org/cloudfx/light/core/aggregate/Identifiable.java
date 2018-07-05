package org.cloudfx.light.core.aggregate;

public interface Identifiable<ID extends Identifier> {
    ID identity();

    void identity(ID aValue);

    boolean isIdentified();

    boolean isUnidentified();
}
