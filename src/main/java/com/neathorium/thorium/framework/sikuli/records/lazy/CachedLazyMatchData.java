package com.neathorium.thorium.framework.sikuli.records.lazy;

import com.neathorium.thorium.framework.core.selector.records.SelectorKeySpecificityData;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;

import java.util.Map;

public record CachedLazyMatchData(LazyMatch MATCH, Map<String, DecoratedList<SelectorKeySpecificityData>> TYPE_KEYS) {}
