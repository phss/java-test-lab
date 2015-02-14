package com.testlab.algorithms.sorting;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class SorterTest {

    @Test
    public void sortSmallList() throws Exception {
        int[] elements = {4, 5, 1, 9, 10, 7, 8, 2, 3, 6};

        Sorter.inplaceSort(elements);

        assertThat(elements, equalTo(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
