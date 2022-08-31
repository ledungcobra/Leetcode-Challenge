package com.ledung;

import java.util.*;

public class NoRepeatingSubString {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int wStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int wEnd = 0; wEnd < s.length(); wEnd++) {
            var curChar = s.charAt(wEnd);
            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
            while (wStart <= wEnd && map.get(curChar) >= 2) {
                var startChar = s.charAt(wStart++);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
            }
            maxLength = Math.max(maxLength, wEnd - wStart + 1);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int wStart = 0;
        int maxLen = 0;
        Map<Character, Integer> charToIndex = new HashMap<>();
        for (int wEnd = 0; wEnd < s.length(); wEnd++) {
            var rightChar = s.charAt(wEnd);
            if (charToIndex.containsKey(rightChar)) {
                wStart = Math.max(wStart, charToIndex.get(rightChar) + 1);
            }
            charToIndex.put(rightChar, wEnd);
            maxLen = Math.max(maxLen, wEnd - wStart + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abbbb"));
    }
}
