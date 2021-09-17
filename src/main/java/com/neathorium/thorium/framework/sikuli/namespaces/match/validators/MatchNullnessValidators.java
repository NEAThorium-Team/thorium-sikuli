package com.neathorium.thorium.framework.sikuli.namespaces.match.validators;

import com.neathorium.thorium.framework.sikuli.constants.RegionDataConstants;
import com.neathorium.thorium.core.extensions.namespaces.NullableFunctions;
import com.neathorium.thorium.core.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.records.Data;
import org.sikuli.script.Match;

import java.util.Objects;

public interface MatchNullnessValidators {
    static boolean isNullMatch(Match match) {
        return (NullableFunctions.isNull(match) || Objects.equals(RegionDataConstants.NULL_REGION_ALL.object, match));
    }

    static boolean isNotNullMatch(Match match) {
        return !isNullMatch(match);
    }

    static boolean isNullMatch(Data<Match> match) {
        return DataPredicates.isInvalidOrFalse(match) || Objects.equals(RegionDataConstants.NULL_REGION_ALL, match) || isNullMatch(match.object);
    }

    static boolean isNotNullMatch(Data<Match> element) {
        return !isNullMatch(element);
    }
}
