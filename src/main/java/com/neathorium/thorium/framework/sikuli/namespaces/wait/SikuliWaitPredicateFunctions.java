package com.neathorium.thorium.framework.sikuli.namespaces.wait;

import com.neathorium.thorium.framework.sikuli.namespaces.SikuliUtilities;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatch;
import com.neathorium.thorium.core.extensions.namespaces.CoreUtilities;
import com.neathorium.thorium.core.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.records.Data;

public interface SikuliWaitPredicateFunctions {
    static <T> boolean isFalsyData(T object) {
        return (
            ((object instanceof Data) && (DataPredicates.isInvalidOrFalse((Data<?>) object))) ||
            ((object instanceof LazyMatch) && (SikuliUtilities.isNullLazyMatch((LazyMatch)object)))
        ) || CoreUtilities.isFalse(object);
    }

    static <T> boolean isTruthyData(T object) {
        return (
            ((object instanceof Data) && (DataPredicates.isValidNonFalse((Data<?>) object))) ||
            ((object instanceof LazyMatch) && (SikuliUtilities.isNullLazyMatch((LazyMatch)object)))
        ) || CoreUtilities.isTrue(object);
    }
}
