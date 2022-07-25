package com.neathorium.thorium.framework.sikuli.namespaces.match.validators;

import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.constants.RegionDataConstants;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import org.sikuli.script.Match;

import java.util.Objects;

public interface MatchNullnessValidators {
    static boolean isNullMatch(Match match) {
        return (NullablePredicates.isNull(match) || Objects.equals(RegionDataConstants.NULL_REGION_ALL.OBJECT(), match));
    }

    static boolean isNotNullMatch(Match match) {
        return !isNullMatch(match);
    }

    static boolean isNullMatch(Data<Match> match) {
        return DataPredicates.isInvalidOrFalse(match) || Objects.equals(RegionDataConstants.NULL_REGION_ALL, match) || isNullMatch(match.OBJECT());
    }

    static boolean isNotNullMatch(Data<Match> element) {
        return !isNullMatch(element);
    }
}
