package com.testlab.algorithms.datastructures;

import java.util.ArrayList;

public class CircularListBasedQueue<T> implements Queue<T> {

    private final ArrayList<T> array = new ArrayList<>();
    private int headIndex = -1;
    private int tailIndex = -1;
    private int counts = 0;

    public CircularListBasedQueue(int maxSize) {
        initializeArray(maxSize);
    }

    @Override
    public void enqueue(T element) {
        counts++;
        incrementTail();
        array.set(tailIndex, element);
        if (headIndex < 0) {
            headIndex = 0;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        counts--;

        T headElement = getAndRemoveFromHead();
        incrementHead();
        return headElement;
    }

    @Override
    public boolean isEmpty() {
        return counts == 0;
    }

    private void initializeArray(int maxSize) {
        for (int i = 0; i < maxSize; i++) {
            array.add(i, null);
        }
    }

    private void incrementTail() {
        tailIndex = (tailIndex + 1) % array.size();
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
