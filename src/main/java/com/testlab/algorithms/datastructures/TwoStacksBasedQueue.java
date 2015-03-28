package com.testlab.algorithms.datastructures;

public class TwoStacksBasedQueue<T> implements Queue<T> {

    private final Stack<T> inputStack;
    private final Stack<T> outputStack;

    public TwoStacksBasedQueue(Stack<T> inputStack, Stack<T> outputStack) {
        this.inputStack = inputStack;
        this.outputStack = outputStack;
    }

    @Override
    public void enqueue(T element) {
        inputStack.push(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        if (outputStack.isEmpty()) {
            migrate();
        }
        return outputStack.pop();
    }

    private void migrate() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }

    @Override
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
