package com.neathorium.thorium.framework.sikuli.records;

import com.neathorium.thorium.framework.sikuli.enums.SikuliTypeKey;

public record SikuliTypedEnumKeyData<T>(SikuliTypeKey KEY, Class<T> CLAZZ) {}
