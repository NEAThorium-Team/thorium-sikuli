package com.neathorium.thorium.framework.sikuli.constants;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.MatchList;
import com.neathorium.thorium.framework.sikuli.namespaces.lazy.factories.LazyMatchFactory;
import com.neathorium.thorium.framework.sikuli.namespaces.utilities.BasicSikuliTypeUtilities;
import com.neathorium.thorium.framework.sikuli.records.lazy.LazyMatch;
import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.framework.core.namespaces.FrameworkFunctions;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;
import com.neathorium.thorium.java.extensions.classes.boilers.StringSet;
import org.sikuli.script.Match;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public abstract class SikuliCoreConstants {
    public static AtomicInteger ATOMIC_COUNT = new AtomicInteger();
    public static final String EMPTY_LOCATOR_STRING = CoreFormatterConstants.EMPTY;

    public static final RuntimeException INVALID_FIND_FAILED_EXCEPTION = new RuntimeException(SikuliFormatterConstants.INVALID_FIND_FAILED_MESSAGE);
    public static final Match NULL_MATCH = new Match();
    public static final Match STOCK_MATCH = BasicSikuliTypeUtilities.getStock();
    public static final List<Match> EMPTY_LIST_OF_MATCH = new ArrayList<>();
    public static final MatchList INVALID_MATCHLIST = new MatchList(EMPTY_LIST_OF_MATCH);
    public static final LazyMatch INVALID_LAZY_MATCH = LazyMatchFactory.getWithDefaultLocatorsAndValidator("Null Lazy Match " + ATOMIC_COUNT.getAndIncrement());
    public static final Function<Data<DecoratedList<?>>, String> MATCH_LIST_VALIDATOR = CoreFormatter.isValidTypedNonEmptyListMessage(Match.class);
    public static final Function<Data<DecoratedList<?>>, Data<Integer>> MATCH_COUNT = FrameworkFunctions.getCountOfElements("Match");

    public static final StringSet NULL_STRING_SET = new StringSet(new HashSet<>());
}
