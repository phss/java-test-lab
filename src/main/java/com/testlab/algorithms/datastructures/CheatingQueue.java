package com.testlab.algorithms.datastructures;

import java.util.concurrent.LinkedBlockingQueue;

public class CheatingQueue<T> implements Queue<T> {

    private final java.util.Queue<T> realQueue = new LinkedBlockingQueue<>();

    @Override
    public void enqueue(T element) {
        realQueue.add(element);
    }

    @Override
    public T dequeue() {
        return realQueue.poll();
    }

    @Override
    public boolean isEmpty() {
        return realQueue.isEmpty();
    }
}
