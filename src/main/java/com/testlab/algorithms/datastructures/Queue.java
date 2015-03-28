package com.testlab.algorithms.datastructures;

public interface Queue<T> {
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
}
