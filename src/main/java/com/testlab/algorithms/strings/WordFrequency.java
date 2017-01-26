package com.testlab.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public Map<String, Integer> calculateFor(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        HashMap<String, Integer> result = new HashMap<>();

        for (String word : words) {
            if (!word.equals("")) {
                if (result.containsKey(word)) {
                    result.put(word, result.get(word) + 1);
                } else {
                    result.put(word, 1);
                }
            }
        }

        return result;
    }
}
