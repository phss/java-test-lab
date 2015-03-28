package com.testlab.algorithms.datastructures;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class QueueTest {


    private final Queue<Integer> queue = new CheatingQueue<>();

    @Test
    public void dequeuesNullWhenQueueHasNoElements() {
        assertThat(queue.isEmpty(), is(true));
        assertThat(queue.dequeue(), is(nullValue()));
    }

    @Test
    public void dequeuesNullWhenQueueWasEmptied() {
        queue.enqueue(1); queue.enqueue(2); queue.enqueue(3);
        queue.dequeue(); queue.dequeue(); queue.dequeue();

        assertThat(queue.isEmpty(), is(true));
        assertThat(queue.dequeue(), is(nullValue()));
    }

    @Test
    public void dequeuesRecentlyPushedElement() {
        queue.enqueue(42);

        assertThat(queue.isEmpty(), is(false));
        assertThat(queue.dequeue(), equalTo(42));
    }

    @Test
    public void dequeuesElementsInRightOrder() {
        queue.enqueue(1); queue.enqueue(2); queue.enqueue(3);

        assertThat(queue.dequeue(), equalTo(1));
        assertThat(queue.dequeue(), equalTo(2));
        assertThat(queue.dequeue(), equalTo(3));
    }

    @Test
    public void mixOfPushesAndPops() {
        queue.enqueue(1); queue.enqueue(2); queue.dequeue(); queue.enqueue(3); queue.enqueue(4);

        assertThat(queue.dequeue(), equalTo(2));
        assertThat(queue.dequeue(), equalTo(3));
        assertThat(queue.dequeue(), equalTo(4));
    }

}