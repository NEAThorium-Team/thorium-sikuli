package com.neathorium.thorium.framework.sikuli.rework.namespaces.formatter;

import com.neathorium.thorium.framework.sikuli.rework.namespaces.RegionFunctions;
import com.neathorium.thorium.framework.sikuli.rework.namespaces.ScreenFunctions;
import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.java.extensions.namespaces.predicates.BasicPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;
import com.neathorium.thorium.java.extensions.namespaces.utilities.BooleanUtilities;
import org.sikuli.script.Region;

public interface RegionFormatterFunctions {
    static String getRegionMetaInformationFormatted(Region region) {
        var message = "";
        final var screen = ScreenFunctions.getScreen(region);
        if (NullablePredicates.isNull(screen)) {
            message = "?";
        }
        if (RegionFunctions.isOnOtherScreen(region)) {
            message = screen.getIDString();
        } else {
            final var id = screen.getID();
            message = (BasicPredicates.isNegative(id) ? "Union" : "" + id);
        }

        final var regionName = region.getName();
        final var nameText = BooleanUtilities.isFalse(regionName.isEmpty()) ? "#" + regionName + "# " : CoreFormatterConstants.EMPTY;
        final var stringFormat = "%sR[%d,%d %dx%d]@S(%s)";
        return String.format(stringFormat, nameText, region.x, region.y, region.w, region.h, message);
    }
}
