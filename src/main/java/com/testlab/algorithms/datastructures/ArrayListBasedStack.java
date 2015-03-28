package com.testlab.algorithms.datastructures;

import java.util.ArrayList;

public class ArrayListBasedStack<T> implements Stack<T> {

    private final ArrayList<T> array = new ArrayList<>();

    @Override
    public void push(T element) {
        array.add(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        int lastIndex = array.size() - 1;
        T lastElement = array.get(lastIndex);
        array.remove(lastIndex);
        return lastElement;
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}
