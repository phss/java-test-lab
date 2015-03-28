package com.testlab.algorithms.datastructures;

import java.util.ArrayList;

public class CircularListBasedQueue<T> implements Queue<T> {

    private final ArrayList<T> array = new ArrayList<>();
    private final int maxSize;
    private int headIndex = -1;
    private int tailIndex = -1;
    private int counts = 0;

    public CircularListBasedQueue(int maxSize) {
        this.maxSize = maxSize;
        for (int i = 0; i < maxSize; i++) {
            array.add(null);
        }
    }

    @Override
    public void enqueue(T element) {
        counts++;
        tailIndex = (tailIndex + 1) % maxSize;
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

        T headElement = array.get(headIndex);
        array.set(headIndex, null);
        headIndex = (headIndex + 1) % maxSize;
        return headElement;
    }

    @Override
    public boolean isEmpty() {
        return counts == 0;
    }
}
