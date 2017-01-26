package com.testlab.algorithms.strings;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.Is.is;

public class WordFrequencyTest {

    private final WordFrequency wordFrequency = new WordFrequency();

    @Test
    public void noResultsForEmptyString() {
        assertThat(wordFrequency.calculateFor("").size(), is(0));
        assertThat(wordFrequency.calculateFor("     ").size(), is(0));
    }

    @Test
    public void frequencyWithSingleEntryForSingleWordText() {
        Map<String, Integer> result = wordFrequency.calculateFor("testing");

        assertThat(result.size(), is(1));
        assertThat(result, hasEntry("testing", 1));
    }

    @Test
    public void frequencyForTextWithOnlyUniqueWords() {
        Map<String, Integer> result = wordFrequency.calculateFor("testing and that's it");

        assertThat(result.size(), is(4));
        assertThat(result, hasEntry("testing", 1));
        assertThat(result, hasEntry("and", 1));
        assertThat(result, hasEntry("that's", 1));
        assertThat(result, hasEntry("it", 1));
    }


}