package com.testlab.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.testlab.guice.services.SimpleGetterService;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GuiceInjectionTest {

    @Test
    public void loadSingleInjectedService() {
        Injector injector = Guice.createInjector(new BasicModule());
        SimpleGetterService service = injector.getInstance(SimpleGetterService.class);

        assertThat(service.getSomeString(), equalTo("I am hardcoded!!!"));
    }
}
