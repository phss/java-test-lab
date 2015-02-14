package com.testlab.algorithms.sorting;

import java.util.Arrays;

public class CheatingSort implements SortingAlgorithm {

    public void inplaceSort(int[] elements) {
        // Cheating
        Arrays.sort(elements);
    }
}
