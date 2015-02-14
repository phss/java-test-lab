package com.testlab.algorithms.searching;

import com.testlab.algorithms.Utils;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

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

    @Ignore
    @Test
    public void findIndexInLargeOrderedList() {
        int[] elements = Utils.randomOrderedIntList(100000000, 30071979);

        long start = System.currentTimeMillis();
        int index = searcher.findIndex(elements, 103599435);
        long elapsed = System.currentTimeMillis() - start;

        assertThat(index, equalTo(4231210));
        assertThat(elapsed, lessThan(1L));
    }

    @Ignore
    @Test
    public void noElementFoundInLargeList() {
        int[] elements = Utils.randomOrderedIntList(100000000, 30071979);

        long start = System.currentTimeMillis();
        int index = searcher.findIndex(elements, -1);
        long elapsed = System.currentTimeMillis() - start;

        assertThat(index, equalTo(-1));
        assertThat(elapsed, lessThan(1L));
    }
}
