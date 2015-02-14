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
}
