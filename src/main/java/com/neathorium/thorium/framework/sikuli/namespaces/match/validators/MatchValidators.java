package com.neathorium.thorium.framework.sikuli.namespaces.match.validators;

import com.neathorium.thorium.framework.sikuli.constants.SikuliCoreConstants;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import org.sikuli.script.Match;

public interface MatchValidators {
    static boolean isNotNull(Match match) {
        return NullablePredicates.isNotNull(match) && EqualsPredicates.isNotEqual(match, SikuliCoreConstants.STOCK_MATCH);
    }
}
