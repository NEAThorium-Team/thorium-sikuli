package com.neathorium.thorium.framework.sikuli.namespaces.region;

import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.RegionFunction;
import com.neathorium.thorium.core.namespaces.DataExecutionFunctions;

import static org.apache.commons.lang3.StringUtils.isBlank;

public interface RegionExecutionFunctions {
    static <T> RegionFunction<T> ifRegion(String nameof, String errorMessage, RegionFunction<T> positive, Data<T> negative) {
        return RegionFunctionFactory.get(DataExecutionFunctions.ifDependency(nameof, isBlank(errorMessage), positive.get(), DataFactoryFunctions.replaceMessage(negative, nameof, errorMessage)));
    }
}
