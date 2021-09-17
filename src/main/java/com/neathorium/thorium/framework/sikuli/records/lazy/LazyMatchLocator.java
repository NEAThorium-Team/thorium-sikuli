package com.neathorium.thorium.framework.sikuli.records.lazy;

import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;

public class LazyMatchLocator extends LazyLocator {
    public final double PRECISION;

    public LazyMatchLocator(String locator, String strategy, double PRECISION) {
        super(locator, strategy);
        this.PRECISION = PRECISION;
    }
}
