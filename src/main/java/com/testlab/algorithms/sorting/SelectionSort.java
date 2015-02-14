package com.testlab.algorithms.sorting;

public class SelectionSort implements SortingAlgorithm {

    public void inplaceSort(int[] elements) {
        int lastIndex = elements.length - 1;

        for (int i = 0; i < lastIndex; i++) {
            int smallestIndex = findIndexOfSmallestElement(elements, i);
            swap(elements, smallestIndex, i);
        }
    }

    private int findIndexOfSmallestElement(int[] elements, int fromIndex) {
        int smallestIndex = fromIndex;
        for (int i = fromIndex; i < elements.length; i++) {
            if (elements[i] < elements[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    private void swap(int[] elements, int i, int j) {
        int buffer = elements[i];
        elements[i] = elements[j];
        elements[j] = buffer;
    }
}
