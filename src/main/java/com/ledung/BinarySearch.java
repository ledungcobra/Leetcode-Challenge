package com.ledung;

public class BinarySearch {
    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;
        while (left <= right) {
            var mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right--;
            } else {
                left++;
            }
        }
        return -1;
    }
}
