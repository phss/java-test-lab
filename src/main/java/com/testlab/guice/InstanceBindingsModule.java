package com.testlab.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.testlab.guice.services.CustomMessageGetterService;
import com.testlab.guice.services.SimpleGetterService;

public class InstanceBindingsModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SimpleGetterService.class)
                .toInstance(new CustomMessageGetterService("Default instance service"));
        bind(SimpleGetterService.class)
                .annotatedWith(Names.named("named"))
                .toInstance(new CustomMessageGetterService("Named instance service"));
    }
}
