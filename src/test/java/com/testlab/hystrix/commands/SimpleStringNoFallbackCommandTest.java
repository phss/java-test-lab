package com.testlab.hystrix.commands;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;

public class SimpleStringNoFallbackCommandTest {

    @Test
    public void returnExpectedValueWhenSetToPass() {
        String response = new SimpleStringNoFallbackCommand("blah", false).execute();

        assertThat(response, equalTo("return value: blah"));
    }
    @Test

    public void usingFutures() throws ExecutionException, InterruptedException {
        Future<String> futureResponse = new SimpleStringNoFallbackCommand("blah", false).queue();

        assertThat(futureResponse.get(), equalTo("return value: blah"));
    }

    @Test
    public void throwExceptionWhenSetToFail() {
        try {
            new SimpleStringNoFallbackCommand("blah", true).execute();
            fail("Should have thrown exception");
        } catch (HystrixRuntimeException e) {
            assertThat(e.getCause().getMessage(), equalTo("failed"));
        }
    }

}