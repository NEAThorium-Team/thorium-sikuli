package com.neathorium.thorium.framework.sikuli.namespaces.wait;

import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.namespaces.SikuliUtilities;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatch;
import com.neathorium.thorium.java.extensions.namespaces.utilities.BooleanUtilities;

public interface SikuliWaitPredicateFunctions {
    static <T> boolean isFalsyData(T object) {
        return (
            ((object instanceof Data) && (DataPredicates.isInvalidOrFalse((Data<?>) object))) ||
            ((object instanceof LazyMatch) && (SikuliUtilities.isNullLazyMatch((LazyMatch)object)))
        ) || BooleanUtilities.isFalse(object);
    }

    static <T> boolean isTruthyData(T object) {
        return (
            ((object instanceof Data) && (DataPredicates.isValidNonFalse((Data<?>) object))) ||
            ((object instanceof LazyMatch) && (SikuliUtilities.isNullLazyMatch((LazyMatch)object)))
        ) || BooleanUtilities.isTrue(object);
    }
}
