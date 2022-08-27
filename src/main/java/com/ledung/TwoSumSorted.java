package com.ledung;

public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        while (p1 < p2) {
            var total = numbers[p1] + numbers[p2];
            if (total == target) {
                return new int[]{p1+1, p2+1};
            } else if (total > target) {
                p2--;
            } else if (total < target) {
                p1++;
            }
        }
        return null;
    }
}
