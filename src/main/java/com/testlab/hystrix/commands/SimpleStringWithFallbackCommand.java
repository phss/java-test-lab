package com.testlab.hystrix.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.exception.HystrixBadRequestException;

public class SimpleStringWithFallbackCommand extends HystrixCommand<String> {
    enum Expectation { PASS, FAIL, BAD_REQUEST }

    public final static String KEY = "FALLBACK_COMMAND";

    private final String returnValue;
    private final Expectation expectation;

    public SimpleStringWithFallbackCommand(String returnValue, Expectation expectation) {
        super(HystrixCommandGroupKey.Factory.asKey(KEY));
        this.returnValue = returnValue;
        this.expectation = expectation;
    }

    @Override
    protected String run() throws Exception {
        switch (expectation) {
            case PASS: return "return value: " + returnValue;
            case FAIL: throw new RuntimeException("failed");
            case BAD_REQUEST: throw new HystrixBadRequestException("bad request");
            default: throw new RuntimeException("should never reach");
        }
    }

    @Override
    protected String getFallback() {
        return "fallback value";
    }
}
