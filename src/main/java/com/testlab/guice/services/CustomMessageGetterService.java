package com.testlab.guice.services;

public class CustomMessageGetterService implements SimpleGetterService {
    private final String message;

    public CustomMessageGetterService(String message) {
        this.message = message;
    }

    @Override
    public String getSomeString() {
        return message;
    }
}
