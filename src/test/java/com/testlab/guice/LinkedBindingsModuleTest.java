package com.testlab.guice;

import com.google.inject.ConfigurationException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.testlab.guice.services.SimpleGetterService;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LinkedBindingsModuleTest {

    @Test
    public void loadSingleInjectedService() {
        Injector injector = Guice.createInjector(new LinkedBindingsModule());
        SimpleGetterService service = injector.getInstance(SimpleGetterService.class);

        assertThat(service.getSomeString(), equalTo("I am hardcoded!!!"));
    }

    @Test
    public void loadNamedService() {
        Injector injector = Guice.createInjector(new LinkedBindingsModule());
        SimpleGetterService service = injector.getInstance(Key.get(SimpleGetterService.class, Names.named("special")));

        assertThat(service.getSomeString(), equalTo("I am also hardcoded!!!"));
    }

    @Test(expected = ConfigurationException.class)
    public void throwsExceptionIfCannotFindNamedService() {
        Injector injector = Guice.createInjector(new LinkedBindingsModule());
        injector.getInstance(Key.get(SimpleGetterService.class, Names.named("nosuchservice")));
    }
}
