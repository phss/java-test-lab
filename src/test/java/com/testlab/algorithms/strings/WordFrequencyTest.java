package com.testlab.algorithms.strings;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WordFrequencyTest {

    private final WordFrequency wordFrequency = new WordFrequency();

    @Test
    public void noResultsForEmptyString() {
        assertThat(wordFrequency.calculateFor("").size(), is(0));
        assertThat(wordFrequency.calculateFor("     ").size(), is(0));
    }

}