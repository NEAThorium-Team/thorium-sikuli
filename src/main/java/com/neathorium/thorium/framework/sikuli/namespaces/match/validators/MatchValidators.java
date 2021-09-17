package com.neathorium.thorium.framework.sikuli.namespaces.match.validators;

import com.neathorium.thorium.framework.sikuli.constants.SikuliCoreConstants;
import com.neathorium.thorium.core.extensions.namespaces.CoreUtilities;
import com.neathorium.thorium.core.extensions.namespaces.NullableFunctions;
import org.sikuli.script.Match;

public interface MatchValidators {
    static boolean isNotNull(Match match) {
        return NullableFunctions.isNotNull(match) && CoreUtilities.isNotEqual(match, SikuliCoreConstants.STOCK_MATCH);
    }
}
