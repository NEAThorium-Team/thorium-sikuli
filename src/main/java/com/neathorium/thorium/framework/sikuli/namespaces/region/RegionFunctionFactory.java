package com.neathorium.thorium.framework.sikuli.namespaces.region;

import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.RegionFunction;
import org.sikuli.script.Region;

import java.util.function.Function;

public interface RegionFunctionFactory {
    static <T> RegionFunction<T> get(Function<Region, Data<T>> function) {
        return function::apply;
    }

    static <T> RegionFunction<T> get(Data<T> data) {
        return region -> DataFactoryFunctions.getWith(data.OBJECT(), data.STATUS(), DataFunctions.getFormattedMessage(data), data.EXCEPTION(), data.EXCEPTION_MESSAGE());
    }
}
