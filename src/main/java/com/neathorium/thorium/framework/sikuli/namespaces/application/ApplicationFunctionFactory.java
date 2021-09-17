package com.neathorium.thorium.framework.sikuli.namespaces.application;

import com.neathorium.thorium.framework.sikuli.namespaces.extensions.boilers.ApplicationFunction;
import com.neathorium.thorium.core.records.Data;
import org.sikuli.script.App;

import java.util.function.Function;

public interface ApplicationFunctionFactory {
    static <T> ApplicationFunction<T> get(Function<App, Data<T>> function) {
        return function::apply;
    }
}
