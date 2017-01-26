package com.testlab.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public Map<String, Integer> calculateFor(String text) {
        String[] words = text.trim().toLowerCase().split("\\s+");
        HashMap<String, Integer> result = new HashMap<>();

        if (text.trim().equals("")) {
            return result;
        }

        for (String word : words) {
            int count = result.getOrDefault(word, 0);
            result.put(word, count + 1);
        }

        return result;
    }
}
