package com.neathorium.thorium.framework.sikuli.namespaces;

import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.constants.MatchStrategyMapConstants;
import com.neathorium.thorium.framework.sikuli.constants.RegionFunctionConstants;
import com.neathorium.thorium.framework.sikuli.constants.SikuliDataConstants;
import com.neathorium.thorium.framework.sikuli.enums.MatchSelectorStrategy;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.LazyMatchLocatorList;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.MatchList;


import com.neathorium.thorium.framework.sikuli.namespaces.match.validators.MatchValidators;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatch;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatchLocator;

import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.framework.core.records.GetByFilterFormatterData;
import com.neathorium.thorium.framework.core.records.GetElementByData;
import com.neathorium.thorium.java.extensions.namespaces.predicates.BasicPredicates;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.ArrayList;
import java.util.function.Function;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public interface SikuliFunctions {
    static String getLocatorStrategy(LazyMatch match) {
        return match.PARAMETERS.keySet().iterator().next();
    }

    static LazyMatchLocator getLazyMatchLocator(LazyMatch match) {
        return null;
    }

    static <T> Data<MatchList> getElements(Region region, LazyMatchLocator locator) {
        final var matches = MatchStrategyMapConstants.STRATEGY_MAP.get(MatchSelectorStrategy.getValueOf(locator.STRATEGY)).apply(locator).apply(region);
        final var status = BasicPredicates.isPositiveNonZero(matches.size());
        return DataFactoryFunctions.getWith(new MatchList(matches), status, "getElements", SikuliFormatters.getFindAllMessage(matches.size(), status));
    }

    static Data<MatchList> getElements(Region region, LazyMatchLocatorList list) {
        if (list.isSingle()) {
            return getElements(region, list.first());
        }

        final var length = list.size();
        final var matches = new MatchList(new ArrayList<>());
        final var message = new StringBuilder();
        var current = SikuliDataConstants.NULL_MATCH_LIST;
        var index = 0;
        LazyMatchLocator locator;
        for (; index < length; ++index) {
            locator = list.get(index);
            current = getElements(region, locator);
            if (DataPredicates.isInvalidOrFalse(current)) {
                message.append((index + 1) + ". locator returned no matches" + CoreFormatterConstants.END_LINE);
            }

            matches.list.addAll(current.OBJECT());
        }

        final var status = BasicPredicates.isPositiveNonZero(matches.size());
        return DataFactoryFunctions.getWith(matches, status, "getElements", SikuliFormatters.getFindAllMessage(matches.size(), status));
    }

    static Function<Region, Data<MatchList>> getElements(LazyMatchLocatorList target) {
        return region -> getElements(region, target);
    }

    static Data<Match> getElement(Region region, LazyMatch x) {
        return null;
    }

    static Data<Match> getElementFromSingle(Region region, LazyMatchLocatorList target) {
        return null;
    }

    static Function<Region, Data<Match>> getElementFromSingle(LazyMatchLocatorList target) {
        return null;
    }

    static <T> Data<Match> getElementBy(GetElementByData<T, Match, MatchList> defaults, Data<MatchList> data, T filter) {
        final var guardName = "getElementBy";
        var errorMessage = "";
        if (isNotBlank(errorMessage)) {
            return DataFactoryFunctions.prependMessage(SikuliDataConstants.NULL_MATCH, guardName, errorMessage);
        }

        final var nameof = defaults.NAMEOF;
        errorMessage = defaults.VALIDATOR.apply(data, filter);
        if (isNotBlank(errorMessage)) {
            return DataFactoryFunctions.prependMessage(defaults.DEFAULT_VALUE, nameof, errorMessage);
        }

        final var object = defaults.GETTER.apply(data, filter);
        final var status = MatchValidators.isNotNull(object);
        final var message = defaults.FORMATTER.apply(new GetByFilterFormatterData<>(filter, defaults.FILTER_NAME, status, data.OBJECT().size(), DataFunctions.getFormattedMessage(data)));
        return DataFactoryFunctions.getWith(object, status, nameof, message);
    }

    static Function<Data<MatchList>, Data<Match>> getElementByContainedText(String message) {
        return data -> getElementBy(RegionFunctionConstants.BY_CONTAINED_TEXT_CONSTANTS, data, message);
    }

    static Function<Data<MatchList>, Data<Match>> getElementByIndex(int index) {
        return data -> getElementBy(RegionFunctionConstants.BY_INDEX_CONSTANTS, data, index);
    }
}
