package com.neathorium.thorium.framework.sikuli.namespaces.validators;

import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.MatchList;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.RegionFunction;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.core.records.Data;
import com.neathorium.thorium.framework.core.namespaces.extensions.boilers.LazyLocatorList;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import org.sikuli.script.Region;

import java.util.function.Function;

public interface SikuliFormatter {
    static String getElementsParametersMessage(LazyLocatorList locators, Function<LazyLocator, RegionFunction<MatchList>> getter) {
        return CoreFormatter.getNamedErrorMessageOrEmpty(
            "getElementsParametersMessage",
            CoreFormatter.isNullOrEmptyMessageWithName(locators, "Lazy Locators List") + CoreFormatter.isNullMessageWithName(getter, "Getter")
        );
    }

    static String getElementsParametersMessage(LazyLocatorList locators) {
        return CoreFormatter.getNamedErrorMessageOrEmpty("getElementsParametersMessage", CoreFormatter.isNullOrEmptyMessageWithName(locators, "Lazy Locators List"));
    }

    static String getNestedElementsErrorMessage(String locator, Data<Region> context) {
        return getLocatorErrorMessage(locator) + CoreFormatter.isInvalidOrFalseMessageWithName(context, "Search Context");
    }

    static String getLocatorErrorMessage(String locator) {
        return CoreFormatter.isNullMessageWithName(locator, "String locator");
    }
}
