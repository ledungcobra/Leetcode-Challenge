package com.ledung;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static String longestSubstringWithKDistinctChars(String s, int k) {
        int wStart = 0;
        String longestStr = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int wEnd = 0; wEnd < s.length(); wEnd++) {
            var curChar = s.charAt(wEnd);
            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
            while (wStart <= wEnd && map.size() > k) {
                var startChar = s.charAt(wStart);
                var countChar = map.get(startChar);
                if (countChar > 1) {
                    map.put(startChar, countChar - 1);
                } else {
                    map.remove(startChar);
                }
                wStart++;
            }

            var curSubStr = s.substring(wStart, wEnd + 1);
            if (curSubStr.length() > longestStr.length()) {
                longestStr = curSubStr;
            }
        }
        return longestStr;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithKDistinctChars("cbbebi", 3));
    }
}
