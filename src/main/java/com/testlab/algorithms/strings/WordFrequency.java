package com.testlab.algorithms.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class WordFrequency {
    public Map<String, Integer> calculateFor(String text) {
        List<String> words = Arrays.asList(text.toLowerCase().split("\\s+"));

        return words.stream()
                .filter(word -> !word.equals(""))
                .collect(groupingBy(identity(), summingInt(w -> 1)));
    }
}
