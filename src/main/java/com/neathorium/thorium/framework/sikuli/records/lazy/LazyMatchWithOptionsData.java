package com.neathorium.thorium.framework.sikuli.records.lazy;

import com.neathorium.thorium.framework.sikuli.records.ExternalSikuliSelectorData;
import com.neathorium.thorium.framework.sikuli.records.lazy.filtered.LazyFilteredMatchParameters;
import com.neathorium.thorium.framework.core.abstracts.AbstractLazyElementWithOptionsData;
import com.neathorium.thorium.framework.core.records.InternalSelectorData;
import com.neathorium.thorium.framework.core.records.ProbabilityData;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;
import org.sikuli.script.Region;

public class LazyMatchWithOptionsData extends AbstractLazyElementWithOptionsData<LazyFilteredMatchParameters, LazyMatch, Region, ExternalSikuliSelectorData> {
    public LazyMatchWithOptionsData(
        LazyMatch element,
        InternalSelectorData internalData,
        ExternalSikuliSelectorData externalData,
        DecoratedList<String> getOrder,
        ProbabilityData probabilityData
    ) {
        super(element, internalData, externalData, getOrder, probabilityData);
    }
}
