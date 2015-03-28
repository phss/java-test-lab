package com.testlab.algorithms.datastructures;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StackTest {

    private final Stack<Integer> stack = new CheatingStack<>();

    @Test
    public void popsNullIfListIsEmpty() {
        assertThat(stack.pop(), is(nullValue()));
    }
}