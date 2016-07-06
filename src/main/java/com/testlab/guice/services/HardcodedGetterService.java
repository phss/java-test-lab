package com.testlab.guice.services;

public class HardcodedGetterService implements SimpleGetterService {
    @Override
    public String getSomeString() {
        return "I am hardcoded!!!";
    }
}
