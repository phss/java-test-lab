package com.testlab.algorithms;

import java.util.Random;

public class Utils {

    public static int[] randomIntList(int size, long seed) {
        Random random = new Random(seed);
        int[] randomElements = new int[size];

        for (int i = 0; i < size; i++) {
            randomElements[i] = Math.abs(random.nextInt());
        }

        return randomElements;
    }

    public static int[] randomOrderedIntList(int size, int seed) {
        Random random = new Random(seed);
        int[] randomElements = new int[size];
        int lastElement = 0;

        for (int i = 0; i < size; i++) {
            randomElements[i] = Math.abs(random.nextInt(50)) + lastElement;
            lastElement = randomElements[i];
        }

        return randomElements;
    }
}
