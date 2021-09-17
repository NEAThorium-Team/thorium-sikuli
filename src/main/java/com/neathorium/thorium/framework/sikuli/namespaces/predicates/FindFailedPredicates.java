package com.neathorium.thorium.framework.sikuli.namespaces.predicates;

import com.neathorium.thorium.core.namespaces.exception.ExceptionFunctions;
import com.neathorium.thorium.framework.sikuli.constants.SikuliCoreConstants;
import com.neathorium.thorium.framework.sikuli.constants.SikuliFormatterConstants;
import com.neathorium.thorium.core.extensions.namespaces.CoreUtilities;
import com.neathorium.thorium.core.namespaces.StringUtilities;
import org.sikuli.script.FindFailed;

public interface FindFailedPredicates {
    static boolean isValidFindFailedException(FindFailed exception) {
        return ExceptionFunctions.isException(exception) && CoreUtilities.isNotEqual(exception, SikuliCoreConstants.INVALID_FIND_FAILED_EXCEPTION);
    }

    static boolean isFindFailed(Exception ex) {
        return StringUtilities.contains(ex.getLocalizedMessage(), SikuliFormatterConstants.FIND_ALL_EXCEPTION_FRAGMENT);
    }

    static boolean isNonFindFailedException(Exception ex) {
        final var message = ex.getLocalizedMessage();
        return (
            StringUtilities.contains(message, SikuliFormatterConstants.NON_FIND_ALL_EXCEPTION) ||
            StringUtilities.uncontains(message, SikuliFormatterConstants.FIND_ALL_EXCEPTION_FRAGMENT)
        );
    }
}
