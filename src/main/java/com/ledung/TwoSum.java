package com.ledung;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var prev = map.get(nums[i]);
            if (prev != null) {
                result[0] = prev;
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
