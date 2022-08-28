package com.ledung;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int leftMax = height[left];
            int rightMax = height[right];
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (leftMax <= rightMax) {
                while (left < right && leftMax >= height[left]) left++;
            } else {
                while (left < right && rightMax >= height[right]) right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
