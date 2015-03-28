package com.testlab.algorithms.datastructures;

public class CheatingStack<T> implements Stack<T> {

    private final java.util.Stack<T> realStack = new java.util.Stack<>();

    @Override
    public void push(T element) {
        realStack.push(element);
    }

    @Override
    public T pop() {
        if (!realStack.empty()) {
            return realStack.pop();
        }
        return null;
    }
}
