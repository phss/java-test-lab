package com.testlab.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class SimpleStringNoFallbackCommand extends HystrixCommand<String> {
    public final static String KEY = "SIMPLE_COMMAND";

    private final String returnValue;
    private final boolean shouldFail;

    public SimpleStringNoFallbackCommand(String returnValue, boolean shouldFail) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(KEY))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter().withMetricsHealthSnapshotIntervalInMilliseconds(10)));
        this.returnValue = returnValue;
        this.shouldFail = shouldFail;
    }

    @Override
    protected String run() throws Exception {
        if (shouldFail) {
            throw new RuntimeException("failed");
        } else {
            return "return value: " + returnValue;
        }
    }
}
