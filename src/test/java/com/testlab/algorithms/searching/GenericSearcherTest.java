package com.testlab.algorithms.searching;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GenericSearcherTest {

    private final SearchingAlgorithm searcher = new SequentialSearch();

    @Test
    public void noElementFound() {
        int[] elements = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};

        int index = searcher.findIndex(elements, 42);

        assertThat(index, equalTo(-1));
    }

    @Test
    public void findIndexInSmallOrderedList() {
        int[] elements = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};

        int index = searcher.findIndex(elements, 13);

        assertThat(index, equalTo(5));
    }
}
