package com.neathorium.thorium.framework.sikuli.namespaces.lazy.factories;

import com.neathorium.thorium.framework.sikuli.constants.SikuliGetOrderConstants;
import com.neathorium.thorium.framework.sikuli.constants.SikuliCoreConstants;
import com.neathorium.thorium.framework.sikuli.records.ExternalSikuliSelectorData;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatch;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatchWithOptionsData;
import com.neathorium.thorium.framework.core.constants.AdjusterConstants;
import com.neathorium.thorium.framework.core.constants.SelectorDataConstants;
import com.neathorium.thorium.framework.core.records.InternalSelectorData;
import com.neathorium.thorium.framework.core.records.ProbabilityData;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;

public interface LazyMatchWithOptionsDataFactory {
    static LazyMatchWithOptionsData get(
        LazyMatch match,
        InternalSelectorData internalData,
        ExternalSikuliSelectorData externalData,
        DecoratedList<String> getOrder,
        ProbabilityData probabilityData
    ) {
        return new LazyMatchWithOptionsData(match, internalData, externalData, getOrder, probabilityData);
    }

    static LazyMatchWithOptionsData getWithDefaultProbabilityData(LazyMatch match, InternalSelectorData internalData, ExternalSikuliSelectorData externalData, DecoratedList<String> getOrder) {
        return get(match, internalData, externalData, getOrder, AdjusterConstants.PROBABILITY_DATA);
    }

    static LazyMatchWithOptionsData getWithDefaultGetOrder(LazyMatch match, InternalSelectorData internalData, ExternalSikuliSelectorData externalData, ProbabilityData probabilityData) {
        return get(match, internalData, externalData, SikuliGetOrderConstants.DEFAULT, probabilityData);
    }

    static LazyMatchWithOptionsData getWithDefaultGetOrderAndProbabilityData(LazyMatch match, InternalSelectorData internalData, ExternalSikuliSelectorData externalData) {
        return getWithDefaultProbabilityData(match, internalData, externalData, SikuliGetOrderConstants.DEFAULT);
    }

    static LazyMatchWithOptionsData getWithDefaultInternalSelectorDataGetOrderAndProbabilityData(LazyMatch match, ExternalSikuliSelectorData externalData) {
        return getWithDefaultGetOrderAndProbabilityData(match, SelectorDataConstants.INTERNAL_SELECTOR_DATA, externalData);
    }

    static LazyMatchWithOptionsData getWithDefaultInternalSelectorDataAndGetOrder(LazyMatch match, ExternalSikuliSelectorData externalData, DecoratedList<String> getOrder) {
        return getWithDefaultProbabilityData(match, SelectorDataConstants.INTERNAL_SELECTOR_DATA, externalData, getOrder);
    }

    static LazyMatchWithOptionsData getWithDefaultInternalSelectorDataAndProbabilityData(LazyMatch match, ExternalSikuliSelectorData externalData, ProbabilityData probabilityData) {
        return getWithDefaultGetOrder(match, SelectorDataConstants.INTERNAL_SELECTOR_DATA, externalData, probabilityData);
    }

    static LazyMatchWithOptionsData getWithSpecificLazyMatch(LazyMatch match) {
        return getWithDefaultInternalSelectorDataGetOrderAndProbabilityData(match, null);
    }

    static LazyMatchWithOptionsData getWithDefaults() {
        return getWithSpecificLazyMatch(SikuliCoreConstants.INVALID_LAZY_MATCH);
    }
}
