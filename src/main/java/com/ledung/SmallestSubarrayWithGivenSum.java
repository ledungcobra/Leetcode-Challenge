package com.ledung;

public class SmallestSubarrayWithGivenSum {

    public int smallestSubarrayWithGivenSum(int[] arr, int s) {
        int minLen = Integer.MAX_VALUE;
        int wSum = 0, wStart = 0;
        for (int wEnd = 0; wEnd < arr.length; wEnd++) {
            wSum += arr[wEnd];
            while (wSum >= s) {
                minLen = Math.min(minLen, wEnd - wStart + 1);
                wSum -= arr[wStart++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {

    }
}
