package com.testlab.algorithms.searching;

public class BinarySearch implements SearchingAlgorithm {

    @Override
    public int findIndex(int[] orderedElements, int element) {
        return binarySearch(orderedElements, element, 0, orderedElements.length - 1);
    }

    private int binarySearch(int[] orderedElements, int element, int lowIndex, int highIndex) {
        int middleIndex = (lowIndex + highIndex) / 2;
        int middleElement = orderedElements[middleIndex];

        if (middleElement == element) {
            return middleIndex;
        } else if (lowIndex > highIndex) {
            return -1;
        } else if (middleElement > element) {
            return binarySearch(orderedElements, element, lowIndex, middleIndex - 1);
        } else {
            return binarySearch(orderedElements, element, middleIndex + 1, highIndex);
        }
    }
}
