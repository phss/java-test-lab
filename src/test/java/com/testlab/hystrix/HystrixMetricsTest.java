package com.testlab.hystrix;

import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.testlab.hystrix.commands.SimpleStringNoFallbackCommand;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class HystrixMetricsTest {

    @Test
    public void reportMetricsForCommandWithoutFallback() throws InterruptedException {
        SimpleStringNoFallbackCommand passingCommand = new SimpleStringNoFallbackCommand("pass", false);
        SimpleStringNoFallbackCommand failingCommand = new SimpleStringNoFallbackCommand("pass", true);

        executeIgnoringException(passingCommand);
        executeIgnoringException(failingCommand);
        executeIgnoringException(passingCommand);
        executeIgnoringException(passingCommand);
        executeIgnoringException(failingCommand);

        Thread.sleep(100);


//        HystrixCommandMetrics metrics = passingCommand.getMetrics();
        HystrixCommandMetrics metrics = HystrixCommandMetrics.getInstance(passingCommand.getCommandKey());
        System.out.println(passingCommand.getMetrics().getHealthCounts());
        System.out.println(failingCommand.getMetrics().getHealthCounts());

        assertThat(metrics.getHealthCounts().getTotalRequests(), equalTo(5));
    }

    private void executeIgnoringException(SimpleStringNoFallbackCommand command) {
        try {
            command.execute();
        } catch (Exception e) {
            // Ignore it!
        }

    }
}
