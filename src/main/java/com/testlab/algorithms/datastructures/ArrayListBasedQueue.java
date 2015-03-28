package com.testlab.algorithms.datastructures;

import java.util.ArrayList;

public class ArrayListBasedQueue<T> implements Queue<T> {

    private final ArrayList<T> array = new ArrayList<>();
    private int headOfQueueIndex = 0;

    @Override
    public void enqueue(T element) {
        array.add(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T headElement = array.get(headOfQueueIndex);
        headOfQueueIndex++;
        return headElement;
    }

    @Override
    public boolean isEmpty() {
        return headOfQueueIndex == array.size();
    }
}
