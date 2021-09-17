package com.neathorium.thorium.framework.sikuli.namespaces.match;

import com.neathorium.thorium.framework.sikuli.constants.RegionDataConstants;
import com.neathorium.thorium.framework.sikuli.enums.ManyMatchesGetter;
import com.neathorium.thorium.framework.sikuli.enums.SingleMatchGetter;
import com.neathorium.thorium.framework.sikuli.namespaces.SikuliFunctions;
import com.neathorium.thorium.framework.sikuli.namespaces.region.RegionFunctionFactory;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.MatchList;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.RegionFunction;
import com.neathorium.thorium.framework.sikuli.namespaces.match.validators.MatchFilterParametersValidators;

import com.neathorium.thorium.core.namespaces.DataExecutionFunctions;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.core.records.Data;
import com.neathorium.thorium.framework.core.abstracts.element.finder.BaseFilterParameters;
import com.neathorium.thorium.framework.core.namespaces.extensions.boilers.LazyLocatorList;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.Map;
import java.util.function.Function;

public interface MatchFilterFunctions {
    private static <T> Function<T, Function<Region, Data<Match>>> getFilteredElement(
        String nameof,
        BaseFilterParameters<Region, ManyMatchesGetter, MatchList> data,
        Function<T, Function<Data<MatchList>, Data<Match>>> filterFunction,
        Function<T, String> valueGuard
    ) {
        return value -> DataExecutionFunctions.ifDependency(
                nameof,
                MatchFilterParametersValidators.isInvalidElementFilterParametersMessage(data) + valueGuard.apply(value),
                DataExecutionFunctions.validChain(data.getterMap.get(data.getter).apply(data.locators), filterFunction.apply(value), RegionDataConstants.NULL_REGION_ALL),
                RegionDataConstants.NULL_REGION_ALL
        );
    }

    static <T, U> Function<Integer, Function<Region, Data<Match>>> getIndexedElement(BaseFilterParameters<Region, ManyMatchesGetter, MatchList> data) {
        return getFilteredElement("getIndexedElement", data, SikuliFunctions::getElementByIndex, CoreFormatter::isNegativeMessage);
    }

    static <T, U> Function<String, Function<Region, Data<Match>>> getContainedTextElement(BaseFilterParameters<Region, ManyMatchesGetter, MatchList> data) {
        return getFilteredElement("getContainedTextElement", data, SikuliFunctions::getElementByContainedText, CoreFormatter::isBlankMessage);
    }

    static RegionFunction<Match> getElement(LazyLocatorList locators, Map<SingleMatchGetter, Function<LazyLocatorList, Function<Region, Data<Match>>>> getterMap, SingleMatchGetter getter) {
        return RegionFunctionFactory.get(
            DataExecutionFunctions.ifDependency(
                "getElement via LazyElement parameters",
                MatchFilterParametersValidators.getSingleMatchGetterErrorMessage(getterMap, getter),
                getterMap.get(getter).apply(locators),
                RegionDataConstants.NULL_REGION_ALL
            )
        );
    }
}