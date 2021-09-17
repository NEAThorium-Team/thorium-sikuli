package com.neathorium.thorium.framework.sikuli.namespaces.validators;

import com.neathorium.thorium.core.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.records.Data;
import org.sikuli.script.Match;

public interface MatchDataValidators {
    static boolean isNull(Data<Match> data) {
        return DataPredicates.isValidNonFalseAndValidContained(data, MatchValidators::isNull);
    }

    static boolean isNotNull(Data<Match> data) {
        return DataPredicates.isValidNonFalseAndValidContained(data, MatchValidators::isNotNull);
    }
}
