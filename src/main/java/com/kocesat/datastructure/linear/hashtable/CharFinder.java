package com.kocesat.datastructure.linear.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    private String str;

    public CharFinder(String str) {
        this.str = str;
    }

    public char firstNonRepeatingChar() {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            int count = charFrequencyMap.containsKey(ch) ? charFrequencyMap.get(ch) : 0;
            charFrequencyMap.put(ch, count + 1);
        }
        for (char ch : chars) {
            if (charFrequencyMap.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE;
    }

    public char firstRepeatingChar() {
        Set<Character> charSet = new HashSet<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (charSet.contains(ch)) {
                return ch;
            }
            charSet.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
