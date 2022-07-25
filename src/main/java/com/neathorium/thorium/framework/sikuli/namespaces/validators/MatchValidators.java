package com.neathorium.thorium.framework.sikuli.namespaces.validators;

import com.neathorium.thorium.framework.sikuli.constants.SikuliCoreConstants;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import org.sikuli.script.Match;

import java.util.Objects;

public interface MatchValidators {
    static boolean isNull(Match match) {
        return NullablePredicates.isNull(match) || Objects.equals(match, SikuliCoreConstants.STOCK_MATCH);
    }

    static boolean isNotNull(Match match) {
        return NullablePredicates.isNotNull(match) && EqualsPredicates.isNotEqual(match, SikuliCoreConstants.STOCK_MATCH);
    }
}
