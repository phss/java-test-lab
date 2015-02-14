package com.testlab.algorithms.searching;

public class SequentialSearch implements SearchingAlgorithm {
    @Override
    public int findIndex(int[] orderedElements, int element) {
        for (int i = 0; i < orderedElements.length; i++) {
            if (orderedElements[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
