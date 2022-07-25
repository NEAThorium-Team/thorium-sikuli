package com.neathorium.thorium.framework.sikuli.records;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.core.abstracts.AbstractExternalElementData;
import com.neathorium.thorium.framework.core.selector.records.SelectorKeySpecificityData;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;
import org.sikuli.script.Match;

import java.util.Map;

public class ExternalMatchData extends AbstractExternalElementData<Match> {
    public ExternalMatchData(Map<String, DecoratedList<SelectorKeySpecificityData>> typeKeys, Data<Match> found) {
        super(typeKeys, found);
    }
}
