package org.cloudfx.light.core.aggregate;

import java.io.Serializable;

public interface Identifier extends Serializable {
    boolean isValid();
}
