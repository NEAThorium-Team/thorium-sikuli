package com.neathorium.thorium.framework.sikuli.constants;

import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.MatchList;
import com.neathorium.thorium.framework.sikuli.namespaces.lazy.factories.LazyMatchFactory;
import com.neathorium.thorium.framework.sikuli.namespaces.utilities.BasicSikuliTypeUtilities;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatch;
import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.extensions.DecoratedList;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.core.records.Data;
import com.neathorium.thorium.framework.core.namespaces.FrameworkFunctions;
import org.sikuli.script.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static com.neathorium.thorium.core.extensions.namespaces.CoreUtilities.getIncrementalUUID;

public abstract class SikuliCoreConstants {
    public static AtomicInteger ATOMIC_COUNT = new AtomicInteger();
    public static final String EMPTY_LOCATOR_STRING = CoreFormatterConstants.EMPTY;

    public static final RuntimeException INVALID_FIND_FAILED_EXCEPTION = new RuntimeException(SikuliFormatterConstants.INVALID_FIND_FAILED_MESSAGE);
    public static final Match NULL_MATCH = new Match();
    public static final Match STOCK_MATCH = BasicSikuliTypeUtilities.getStock();
    public static final List<Match> EMPTY_LIST_OF_MATCH = new ArrayList<>();
    public static final MatchList INVALID_MATCHLIST = new MatchList(EMPTY_LIST_OF_MATCH);
    public static final LazyMatch INVALID_LAZY_MATCH = LazyMatchFactory.getWithDefaultLocatorsAndValidator("Null Lazy Match " + getIncrementalUUID(ATOMIC_COUNT));
    public static final Function<Data<DecoratedList<?>>, String> MATCH_LIST_VALIDATOR = CoreFormatter.isValidTypedNonEmptyListMessage(Match.class);
    public static final Function<Data<DecoratedList<?>>, Data<Integer>> MATCH_COUNT = FrameworkFunctions.getCountOfElements("Match");
}
