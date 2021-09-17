package devtests.windows.constants;

import com.neathorium.thorium.framework.sikuli.enums.MatchSelectorStrategy;
import com.neathorium.thorium.framework.sikuli.namespaces.lazy.factories.LazyMatchFactory;
import com.neathorium.thorium.framework.sikuli.namespaces.lazy.factories.LazyMatchLocatorFactory;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatch;
import com.neathorium.thorium.core.constants.project.ProjectPathConstants;

public abstract class DesktopConstants {
    public static final String NAME = "Desktop - ";
    public static final String COMPONENT_PATH = ProjectPathConstants.PROJECT_ROOT + "/src/main/resources/Windows10/";

    public static final String START_BUTTON_NAME = NAME + "Start Button";
    public static final String START_BUTTON_PATH = COMPONENT_PATH + "start-menu-button-cropped-no-values.png";

    public static final LazyMatch START_BUTTON = LazyMatchFactory.getWithFilterParameters(START_BUTTON_NAME, LazyMatchLocatorFactory.getWith(START_BUTTON_PATH, MatchSelectorStrategy.IMAGE));
    public static final LazyMatch INTELLIJ_TEXT = LazyMatchFactory.getWithFilterParameters("IntelliJ text", LazyMatchLocatorFactory.getWith("IntelliJ", MatchSelectorStrategy.TEXT));

}
