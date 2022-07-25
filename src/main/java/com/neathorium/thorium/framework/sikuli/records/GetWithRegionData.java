package com.neathorium.thorium.framework.sikuli.records;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.core.records.lazy.GetWithBaseData;
import org.sikuli.script.Region;

import java.util.function.Function;

public class GetWithRegionData<T, U, V, W> extends GetWithBaseData<Region, T, U, V, W> {
    public GetWithRegionData(T locators, Function<T, U> locatorGetter, Function<V, Function<Region, Data<W>>> getter, Data<W> guardData) {
        super(locators, locatorGetter, getter, guardData);
    }
}
