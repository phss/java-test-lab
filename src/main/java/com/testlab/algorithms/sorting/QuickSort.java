package com.testlab.algorithms.sorting;

public class QuickSort implements SortingAlgorithm {

    @Override
    public void inplaceSort(int[] elements) {
        quickSort(elements, 0, elements.length - 1);
    }

    private void quickSort(int[] elements, int lowIndex, int highIndex) {
        if ((highIndex - lowIndex) > 0) {
            int partitionIndex = partition(elements, lowIndex, highIndex);
            quickSort(elements, lowIndex, partitionIndex - 1);
            quickSort(elements, partitionIndex + 1, highIndex);
        }
    }

    private int partition(int[] elements, int lowIndex, int highIndex) {
        int partitionIndex = lowIndex;

        for (int i = lowIndex; i < highIndex; i++) {
            if (elements[i] < elements[highIndex]) {
                swap(elements, partitionIndex, i);
                partitionIndex += 1;
            }
        }
        swap(elements, highIndex, partitionIndex);

        return partitionIndex;
    }

    private void swap(int[] elements, int i, int j) {
        int buffer = elements[i];
        elements[i] = elements[j];
        elements[j] = buffer;
    }
}
