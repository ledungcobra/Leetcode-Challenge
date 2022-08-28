package com.ledung;

import java.util.Arrays;

public class SquareSortedArray {
    public static int[] sortedSquares(int[] nums) {
        var rIndex = nums.length - 1;
        var right = nums.length - 1;
        var left = 0;
        var result = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                result[rIndex--] = nums[right] * nums[right];
                right--;
            } else {
                result[rIndex--] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0,  10})));
    }
}
