package com.testlab.algorithms.datastructures;

import java.util.ArrayList;

public class ArrayListBasedStack<T> implements Stack<T> {

    private final ArrayList<T> array = new ArrayList<>();
    private int lastIndex = -1;

    @Override
    public void push(T element) {
        array.add(element);
        lastIndex++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T lastElement = array.get(lastIndex);
        array.remove(lastIndex);
        lastIndex--;
        return lastElement;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex < 0;
    }
}
