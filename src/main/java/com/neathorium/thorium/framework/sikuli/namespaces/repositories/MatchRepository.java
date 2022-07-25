package com.neathorium.thorium.framework.sikuli.namespaces.repositories;

import com.neathorium.selector.specificity.enums.Strategy;
import com.neathorium.selector.specificity.namespaces.Specificity;
import com.neathorium.selector.specificity.tuples.SpecificityData;
import com.neathorium.thorium.core.data.constants.CoreDataConstants;
import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.constants.MatchStrategyMapConstants;
import com.neathorium.thorium.framework.sikuli.constants.SikuliDataConstants;
import com.neathorium.thorium.framework.sikuli.constants.SikuliFormatterConstants;
import com.neathorium.thorium.framework.sikuli.constants.SikuliRepositoryConstants;
import com.neathorium.thorium.framework.sikuli.namespaces.SikuliUtilities;
import com.neathorium.thorium.framework.sikuli.namespaces.match.MatchRepositoryValidators;
import com.neathorium.thorium.framework.sikuli.records.lazy.CachedLazyMatchData;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatch;
import com.neathorium.thorium.framework.sikuli.records.lazy.filtered.LazyFilteredMatchParameters;
import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.framework.core.abstracts.AbstractLazyResult;
import com.neathorium.thorium.framework.core.namespaces.extensions.boilers.LazyLocatorList;
import com.neathorium.thorium.framework.core.namespaces.repositories.CoreElementRepository;
import com.neathorium.thorium.framework.core.namespaces.validators.FrameworkCoreFormatter;
import com.neathorium.thorium.framework.core.selector.records.SelectorKeySpecificityData;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import com.neathorium.thorium.java.extensions.namespaces.utilities.BooleanUtilities;

import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public interface MatchRepository {
    static Data<Boolean> cacheMatch(Map<String, CachedLazyMatchData> elementRepository, LazyMatch element, Map<String, DecoratedList<SelectorKeySpecificityData>> typeKeys, Data<Boolean> defaultValue) {
        final var nameof = "cacheMatch";
        final var errorMessage = FrameworkCoreFormatter.isNullLazyElementMessage(element);
        if (isNotBlank(errorMessage)) {
            return DataFactoryFunctions.replaceMessage(defaultValue, nameof, SikuliFormatterConstants.LAZY_MATCH + " " + CoreFormatterConstants.WAS_NULL);
        }

        final var name = element.NAME;
        if (elementRepository.containsKey(name)) {
            return DataFactoryFunctions.replaceMessage(defaultValue, nameof, SikuliFormatterConstants.LAZY_MATCH + " with name(\"" + name + "\") was already stored" + CoreFormatterConstants.END_LINE);
        }

        elementRepository.put(name, new CachedLazyMatchData(element, typeKeys));
        final var status = elementRepository.containsKey(name);
        final var message = (status ? "Lazy Element with name(\"" + name + "\") added to cache" : "Lazy Element with name(\"" + name + "\") not added to cache") + CoreFormatterConstants.END_LINE;
        return DataFactoryFunctions.getBoolean(status, nameof, message);
    }

    static Data<Boolean> cacheMatch(LazyMatch element, Map<String, DecoratedList<SelectorKeySpecificityData>> typeKeys, Data<Boolean> defaultValue) {
        return cacheMatch(SikuliRepositoryConstants.elements, element, typeKeys, defaultValue);
    }

    static Data<Boolean> cacheMatch(LazyMatch element, Map<String, DecoratedList<SelectorKeySpecificityData>> typeKeys) {
        return cacheMatch(SikuliRepositoryConstants.elements, element, typeKeys, CoreDataConstants.NULL_BOOLEAN);
    }

    static Data<Boolean> containsElement(Map<String, CachedLazyMatchData> elementRepository, String name, Data<Boolean> defaultValue) {
        final var nameof = "containsElement";
        final var errorMessage = MatchRepositoryValidators.isInvalidContainsMatchMessage(elementRepository, name, defaultValue);
        if (isNotBlank(errorMessage)) {
            return DataFactoryFunctions.replaceMessage(defaultValue, nameof, errorMessage);
        }

        final var defaultObject = defaultValue.OBJECT();
        final var object = elementRepository.containsKey(name);
        final var message = SikuliFormatterConstants.LAZY_MATCH + CoreFormatter.getOptionMessage(object) + " found by name(\"" + name + "\")" + CoreFormatterConstants.END_LINE;

        return DataFactoryFunctions.getWith(object, true, nameof, message);
    }

    static Data<Boolean> containsElement(String name, Data<Boolean> defaultValue) {
        return containsElement(SikuliRepositoryConstants.elements, name, defaultValue);
    }

    static Data<Boolean> containsElement(String name) {
        return containsElement(SikuliRepositoryConstants.elements, name, CoreDataConstants.NULL_BOOLEAN);
    }

    static Data<CachedLazyMatchData> getElement(Map<String, CachedLazyMatchData> elementRepository, String name, Data<CachedLazyMatchData> defaultValue) {
        final var nameof = "getElement";
        final var errorMessage = MatchRepositoryValidators.isInvalidContainsMatchMessage(elementRepository, name, defaultValue);
        if (isNotBlank(errorMessage)) {
            return DataFactoryFunctions.replaceMessage(defaultValue, nameof, errorMessage);
        }

        final var defaultObject = defaultValue.OBJECT();
        final var object = elementRepository.getOrDefault(name, defaultObject);
        final var status = EqualsPredicates.isNotEqual(object, defaultObject);
        final var message = SikuliFormatterConstants.LAZY_MATCH + CoreFormatter.getOptionMessage(status) + " found by name(\"" + name + "\")" + CoreFormatterConstants.END_LINE;

        return DataFactoryFunctions.getWith(object, status, nameof, message);
    }

    static Data<CachedLazyMatchData> getElement(String name, Data<CachedLazyMatchData> defaultValue) {
        return getElement(SikuliRepositoryConstants.elements, name, defaultValue);
    }

    static Data<CachedLazyMatchData> getElement(Map<String, CachedLazyMatchData> elementRepository, String name) {
        return getElement(elementRepository, name, SikuliDataConstants.NULL_CACHED_LAZY_MATCH);
    }

    static Data<CachedLazyMatchData> getElement(String name) {
        return getElement(SikuliRepositoryConstants.elements, name);
    }

    static <T> String cacheIfAbsent(AbstractLazyResult<LazyFilteredMatchParameters> element, Map<String, DecoratedList<SelectorKeySpecificityData>> typeKeys) {
        final var cached = MatchRepository.containsElement(element.NAME);

        var message = "";
        if (DataPredicates.isValidNonFalse(cached) && !cached.OBJECT()) {
            final var cachedElement = new LazyMatch(element.NAME, SikuliUtilities.getParametersCopy(element.PARAMETERS), element.VALIDATOR);
            message = DataFunctions.getFormattedMessage(MatchRepository.cacheMatch(cachedElement, typeKeys));
        }

        return message;
    }

    static Map<String, DecoratedList<SelectorKeySpecificityData>> getInitializedTypeKeysMap() {
        return CoreElementRepository.getInitializedTypeKeysMap(MatchStrategyMapConstants.STRATEGY_MAP_KEY_SET, String.class);
    }

    static <T> Data<CachedLazyMatchData> getIfContains(AbstractLazyResult<T> element) {
        final var name = element.NAME;
        return DataPredicates.isValidNonFalse(MatchRepository.containsElement(name)) ? MatchRepository.getElement(name) : SikuliDataConstants.MATCH_WAS_NOT_CACHED;
    }

    static Data<Boolean> updateTypeKeys(LazyLocatorList locators, Map<String, DecoratedList<SelectorKeySpecificityData>> typeKeys, List<String> types, String key) {
        final var nameof = "updateTypeKeys";
        if (NullablePredicates.isNull(key)) {
            return DataFactoryFunctions.replaceMessage(CoreDataConstants.NULL_BOOLEAN, nameof, "Strategy passed" + CoreFormatterConstants.WAS_NULL);
        }

        final var typeKey = types.stream().filter(key::contains).findFirst();
        if (typeKey.isEmpty()) {
            return DataFactoryFunctions.replaceMessage(CoreDataConstants.NULL_BOOLEAN, nameof, "Types didn't contain type key(\"" + typeKey + "\")" + CoreFormatterConstants.END_LINE);
        }

        final var type = typeKeys.get(typeKey.get());
        final var selectorKeySpecificityData = getSpecificityForSelector(locators, key);
        if (NullablePredicates.isNotNull(type)) {
            type.addNullSafe(selectorKeySpecificityData);
        }

        final var status = type.contains(selectorKeySpecificityData);
        final var message = "Key(\"" + key + "\") with specificity was " + CoreFormatter.getOptionMessage(status) + " added" + CoreFormatterConstants.END_LINE;
        return DataFactoryFunctions.getBoolean(status, message);
    }

    static Data<Boolean> updateTypeKeys(String name, LazyLocatorList locators, Map<String, DecoratedList<SelectorKeySpecificityData>> typeKeys, List<String> types, String key) {
        final var nameof = "updateTypeKeys";
        final var cached = containsElement(name);
        if (DataPredicates.isInvalidOrFalse(cached)) {
            return DataFactoryFunctions.prependMessage(cached, nameof, "There were parameter issues" + CoreFormatterConstants.END_LINE);
        }

        return BooleanUtilities.isFalse(cached.OBJECT()) ? (updateTypeKeys(locators, typeKeys, types, key)) : DataFactoryFunctions.getBoolean(true, nameof, "Element(\"" + name + "\") was already cached" + CoreFormatterConstants.END_LINE);
    }

    static SelectorKeySpecificityData getSpecificityForSelector(LazyLocatorList list, String key) {
        return new SelectorKeySpecificityData(
            key,
            Specificity.reduce(
                list.stream().map(
                    locator -> Specificity.getSelectorSpecificity(locator.LOCATOR, Strategy.OTHER).SPECIFICS
                ).toArray(SpecificityData[]::new)
            )
        );
    }
}
