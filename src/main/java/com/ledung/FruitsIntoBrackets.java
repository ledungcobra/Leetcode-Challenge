package com.ledung;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FruitsIntoBrackets {

    public static List<Character> fruitsIntoBrackets(char[] arr) {
        int MAX_CHARS = 2;
        var result = new LinkedList<Character>();
        var map = new HashMap<Character, Integer>();
        int wStart = 0;
        List<Character> max = new LinkedList<>();
        for (int wEnd = 0; wEnd < arr.length; wEnd++) {
            var curChar = arr[wEnd];
            result.add(curChar);
            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
            while (wStart <= wEnd && map.size() > MAX_CHARS) {
                var startChar = arr[wStart];
                var startCharCount = map.get(startChar);
                map.put(startChar, startCharCount - 1);
                if (map.get(startChar) <= 0) {
                    map.remove(startChar);
                }
                result.removeFirst();
                wStart++;
            }
            if (max.size() < result.size()) {
                max = result;
            }
        }
        return max;
    }

    public static int totalFruit(int[] fruits) {
        int max = 0;
        int wStart = 0;
        int MAX = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int wEnd = 0; wEnd < fruits.length; wEnd++) {
            map.put(fruits[wEnd], map.getOrDefault(fruits[wEnd], 0) + 1);
            while (wStart <= wEnd && map.size() > MAX) {
                var fruitStart = fruits[wStart];
                map.put(fruitStart, map.get(fruitStart) - 1);
                if (map.get(fruitStart) == 0) {
                    map.remove(fruitStart);
                }
                wStart++;
            }
            max = Math.max(max, wEnd - wStart + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(fruitsIntoBrackets(new char[]{'A', 'B', 'C', 'A', 'C'}));
    }
}
