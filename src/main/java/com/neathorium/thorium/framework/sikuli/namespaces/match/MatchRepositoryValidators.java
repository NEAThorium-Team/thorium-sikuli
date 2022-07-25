package com.neathorium.thorium.framework.sikuli.namespaces.match;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.records.lazy.CachedLazyMatchData;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;

import java.util.Map;

public interface MatchRepositoryValidators {
    static <T> String isInvalidContainsMatchMessage(Map<String, CachedLazyMatchData> matchRepository, String name, Data<?> defaultValue) {
        var message = (
            CoreFormatter.isNullMessageWithName(matchRepository, "Match Repository") +
            CoreFormatter.isBlankMessageWithName(name, "Name") +
            CoreFormatter.isNullMessageWithName(defaultValue, "Default Data Value")
        );
        return CoreFormatter.getNamedErrorMessageOrEmpty("isInvalidContainsMatchMessage", message);
    }
}
