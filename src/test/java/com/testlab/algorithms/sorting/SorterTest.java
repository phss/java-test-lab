package com.testlab.algorithms.sorting;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SorterTest {

    @Test
    public void sortSmallList() throws Exception {
        int[] elements = {4, 5, 1, 9, 10, 7, 8, 2, 3, 6};

        Sorter.inplaceSort(elements);

        assertThat(elements, equalTo(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void sortListWithDuplicates() throws Exception {
        int[] elements = {4, 5, 1, 1, 5, 7, 3, 2, 3, 6};

        Sorter.inplaceSort(elements);

        assertThat(elements, equalTo(new int[] {1, 1, 2, 3, 3, 4, 5, 5, 6, 7}));
    }

    @Ignore
    @Test
    public void sortLargeRandomList() throws Exception {
        int listSize = 100000000;
        int[] elements = randomIntList(listSize, 30071979);

        Sorter.inplaceSort(elements);

        assertThat(elements[0], equalTo(9));
        assertThat(elements[listSize / 2], equalTo(1073753667));
        assertThat(elements[listSize - 1], equalTo(2147483647));
    }

    private int[] randomIntList(int size, long seed) {
        Random random = new Random(seed);
        int[] randomElements = new int[size];

        for (int i = 0; i < size; i++) {
            randomElements[i] = Math.abs(random.nextInt());
        }

        return randomElements;
    }
}
