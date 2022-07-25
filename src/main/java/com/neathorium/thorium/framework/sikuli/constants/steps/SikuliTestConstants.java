package com.neathorium.thorium.framework.sikuli.constants.steps;

import com.neathorium.thorium.core.data.interfaces.DataSupplier;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.sikuli.environment.enums.ScreenKey;
import com.neathorium.thorium.framework.sikuli.environment.namespaces.ScreenFactory;
import com.neathorium.thorium.core.namespaces.executor.step.StepFactory;
import org.sikuli.script.Match;
import org.sikuli.script.Region;

import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class SikuliTestConstants {
    public static final BiFunction<Function<Region, Data<Boolean>>, ScreenKey, DataSupplier<Boolean>> STEP = StepFactory.step(ScreenFactory::get);
    public static final BiFunction<Function<Region, Data<Match>>, ScreenKey, DataSupplier<Match>> MATCH_STEP = StepFactory.step(ScreenFactory::get);
}
