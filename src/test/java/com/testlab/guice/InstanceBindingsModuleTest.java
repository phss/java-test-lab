package com.testlab.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.testlab.guice.services.SimpleGetterService;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class InstanceBindingsModuleTest {

    @Test
    public void loadInstanceBindings() {
        Injector injector = Guice.createInjector(new InstanceBindingsModule());

        SimpleGetterService service = injector.getInstance(SimpleGetterService.class);
        assertThat(service.getSomeString(), equalTo("Default instance service"));

        SimpleGetterService anotherService = injector.getInstance(Key.get(SimpleGetterService.class, Names.named("named")));
        assertThat(anotherService.getSomeString(), equalTo("Named instance service"));
    }
}
