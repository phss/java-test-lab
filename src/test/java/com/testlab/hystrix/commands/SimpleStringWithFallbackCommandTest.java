package com.testlab.hystrix.commands;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.junit.Test;

import static com.testlab.hystrix.commands.SimpleStringWithFallbackCommand.Expectation.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;

public class SimpleStringWithFallbackCommandTest {

    @Test
    public void returnExpectedValueWhenSetToPass() {
        String response = new SimpleStringWithFallbackCommand("blah", PASS).execute();

        assertThat(response, equalTo("return value: blah"));
    }

    @Test
    public void returnFallbackValueWhenSetToFail() {
        String response = new SimpleStringWithFallbackCommand("blah", FAIL).execute();

        assertThat(response, equalTo("fallback value"));
    }

    @Test
    public void throwExceptionWhenSetToBadRequest() {
        try {
            new SimpleStringWithFallbackCommand("blah", BAD_REQUEST).execute();
            fail("Should have thrown exception");
        } catch (HystrixBadRequestException e) {
            assertThat(e.getMessage(), equalTo("bad request"));
        }
    }

}