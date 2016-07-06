package com.testlab.guice;

import com.google.inject.AbstractModule;
import com.testlab.guice.services.HardcodedGetterService;
import com.testlab.guice.services.SimpleGetterService;

public class BasicModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SimpleGetterService.class).to(HardcodedGetterService.class);
    }
}
