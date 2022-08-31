package com.ledung;

public class SlidingWindows {

    // 1 2 3 -> k = 2 n = 3 -> result = 2;
    public static double[] findAverages(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        int z = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            sum /= k;
            result[z++] = sum;
        }
        return result;
    }

    public static double[] findAverages2(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        int windowStart = 0;
        double windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }

    public static int maximumSumArray(int k, int[] arr) {
        int wStart = 0;
        int max = Integer.MIN_VALUE;
        int wSum = 0;
        int indexWindowEnd = k - 1;
        for (int wEnd = 0; wEnd < arr.length; wEnd++) {
            wSum += arr[wEnd];
            if (wEnd >= indexWindowEnd) {
                max = Math.max(wSum, max);
                wSum -= arr[wStart++];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        var timer = new Timer().tick();
        var arr = new int[]{2, 1, 5, 1, 3, 2};
        System.out.println(maximumSumArray(3, arr));
        System.out.println(timer.stop().report());
    }
}
