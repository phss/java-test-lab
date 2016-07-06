package com.testlab.guice.services;

public class AnotherHardcodedGetterService implements SimpleGetterService {
    @Override
    public String getSomeString() {
        return "I am also hardcoded!!!";
    }
}
