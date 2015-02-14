package com.testlab.algorithms.searching;

import java.util.Arrays;
import java.util.List;

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
