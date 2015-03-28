package com.testlab.algorithms.datastructures;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StackTest {

    private final Stack<Integer> stack = new CheatingStack<>();

    @Test
    public void popsNullWhenStackHasNoElements() {
        assertThat(stack.isEmpty(), is(true));
        assertThat(stack.pop(), is(nullValue()));
    }

    @Test
    public void popsNullWhenStackWasEmptied() {
        stack.push(1); stack.push(2); stack.push(3);
        stack.pop(); stack.pop(); stack.pop();

        assertThat(stack.isEmpty(), is(true));
        assertThat(stack.pop(), is(nullValue()));
    }

    @Test
    public void popsRecentlyPushedElement() {
        stack.push(42);

        assertThat(stack.isEmpty(), is(false));
        assertThat(stack.pop(), equalTo(42));
    }

    @Test
    public void popsElementsInRightOrder() {
        stack.push(1); stack.push(2); stack.push(3);

        assertThat(stack.pop(), equalTo(3));
        assertThat(stack.pop(), equalTo(2));
        assertThat(stack.pop(), equalTo(1));
    }

    @Test
    public void mixOfPushesAndPops() {
        stack.push(1); stack.push(2); stack.pop(); stack.push(3); stack.push(4);

        assertThat(stack.pop(), equalTo(4));
        assertThat(stack.pop(), equalTo(3));
        assertThat(stack.pop(), equalTo(1));
    }
}