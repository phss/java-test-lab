package com.testlab.algorithms.sorting;

import com.testlab.algorithms.Utils;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GenericSortingTest {

    private final SortingAlgorithm sorter = new CheatingSort();

    @Test
    public void sortSmallList() throws Exception {
        int[] elements = {4, 5, 1, 9, 10, 7, 8, 2, 3, 6};

        double elapsedTime = inplaceSortAndTime(elements);

        assertThat(elements, equalTo(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertThat(elapsedTime, lessThan(1.0));
    }

    @Test
    public void sortListWithDuplicates() throws Exception {
        int[] elements = {4, 5, 1, 1, 5, 7, 3, 2, 3, 6};

        double elapsedTime = inplaceSortAndTime(elements);

        assertThat(elements, equalTo(new int[] {1, 1, 2, 3, 3, 4, 5, 5, 6, 7}));
        assertThat(elapsedTime, lessThan(1.0));
    }

    @Ignore
    @Test
    public void sortLargeRandomList() throws Exception {
        int listSize = 100000000;
        int[] elements = Utils.randomIntList(listSize, 30071979);


        double elapsedTime = inplaceSortAndTime(elements);

        assertThat(elements[0], equalTo(9));
        assertThat(elements[listSize / 2], equalTo(1073753667));
        assertThat(elements[listSize - 1], equalTo(2147483647));
        assertThat(elapsedTime, lessThan(15.0));
    }

    private double inplaceSortAndTime(int[] elements) {
        long start = System.currentTimeMillis();
        sorter.inplaceSort(elements);
        long end = System.currentTimeMillis();
        return ((end - start) / 1000);
    }

}
