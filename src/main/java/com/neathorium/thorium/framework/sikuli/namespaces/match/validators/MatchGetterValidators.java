package com.neathorium.thorium.framework.sikuli.namespaces.match.validators;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.MatchList;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.core.namespaces.validators.DataValidators;

public interface MatchGetterValidators {
    static String isInvalidElementByTextParameters(Data<MatchList> data, String text) {
        return CoreFormatter.getNamedErrorMessageOrEmpty("getElementByTextParametersInvalidMessage", DataValidators.isInvalidOrFalseMessage(data) + CoreFormatter.isBlankMessageWithName(text, "Text"));
    }
}
