package com.neathorium.thorium.framework.sikuli.records.lazy.filtered;

import com.neathorium.thorium.framework.sikuli.enums.ManyMatchesGetter;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.LazyMatchLocatorList;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.MatchList;
import com.neathorium.thorium.framework.sikuli.records.MatchFilterParameters;
import com.neathorium.thorium.framework.core.abstracts.lazy.filtered.AbstractLazyFilteredElementParameters;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

public class LazyFilteredMatchParameters extends AbstractLazyFilteredElementParameters<Region, ManyMatchesGetter, MatchFilterParameters, LazyMatchLocatorList, MatchList, Match> {
    public LazyFilteredMatchParameters(MatchFilterData<?> elementFilterData, Class<?> clazz, double probability, LazyMatchLocatorList lazyLocators, String getter) {
        super(elementFilterData, clazz, probability, lazyLocators, getter);
    }
}
