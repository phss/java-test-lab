package com.testlab.algorithms.sorting;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class SorterTest {

    @Test
    public void sortSmallList() throws Exception {
        List<Integer> elements = asList(4, 5, 1, 9, 10, 7, 8, 2, 3, 6);

        List<Integer> sortedElements = Sorter.sort(elements);

        assertThat(sortedElements, contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
