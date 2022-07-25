package com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers;

import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatchLocator;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;

import java.util.List;

public class LazyMatchLocatorList extends DecoratedList<LazyMatchLocator> {
    public LazyMatchLocatorList(List<LazyMatchLocator> list) {
        super(list, LazyMatchLocator.class.getTypeName());
    }

    public LazyMatchLocatorList subList(int fromIndex, int toIndex) {
        return new LazyMatchLocatorList(super.subList(fromIndex, toIndex));
    }

    public LazyMatchLocatorList tail() {
        return new LazyMatchLocatorList(super.tail());
    }

    public LazyMatchLocatorList initials() {
        return new LazyMatchLocatorList(super.initials());
    }
}
