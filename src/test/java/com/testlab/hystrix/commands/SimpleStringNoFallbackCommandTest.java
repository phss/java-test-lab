package com.testlab.hystrix.commands;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SimpleStringNoFallbackCommandTest {

    @Test
    public void returnExpectedValueWhenSetToPass() {
        String response = new SimpleStringNoFallbackCommand("blah", false).execute();

        assertThat(response, equalTo("return value: blah"));
    }

}