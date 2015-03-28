package com.testlab.algorithms.datastructures;

import java.util.ArrayList;

public class CircularListBasedQueue<T> implements Queue<T> {

    private final ArrayList<T> array = new ArrayList<>();
    private int headIndex = 0;
    private int nextElementIndex = 0;

    public CircularListBasedQueue(int maxSize) {
        initializeArray(maxSize);
    }

    @Override
    public void enqueue(T element) {
        array.set(nextElementIndex, element);
        incrementNextElement();
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T headElement = getAndRemoveFromHead();
        incrementHead();
        return headElement;
    }

    @Override
    public boolean isEmpty() {
        return headIndex == nextElementIndex;
    }

    private void initializeArray(int maxSize) {
        for (int i = 0; i < maxSize; i++) {
            array.add(i, null);
        }
    }

    private void incrementNextElement() {
        nextElementIndex = (nextElementIndex + 1) % array.size();
    }

    private void incrementHead() {
        headIndex = (headIndex + 1) % array.size();
    }

    private T getAndRemoveFromHead() {
        T headElement = array.get(headIndex);
        array.set(headIndex, null);
        return headElement;
    }
}
