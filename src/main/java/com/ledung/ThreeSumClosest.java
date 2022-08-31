package com.ledung;

import java.util.Arrays;

/**
 * @author ledung
 *  example: given array [-1, 2,1,-4] and target 1
 *  * closet = -1 + 2 + -4 -> -3
 *  nums = [-4, -1, 1, 2]
 *  for
 *  Step i = 0
 *      start = i + 1 = 1
 *      end = 3
 *      while( start < end) // 1 < 3 -> true
 *          curSum = nums[0] + nums[1] + nums[3] -> -4 + -1 + 2 -> -3
 *          if(| 1 - - 3 | < | 1 - -3 |)  -> false
 *          if(curSum == target) // -3 == 1 -> false
 *          if(curSum < target) // -3 < 1 -> true -> start++ -> start = 2
 *      ------------------------------------------------------------------
 *      while(start < end)  // 2 < 3 -> true
 *          curSum = sum[0] + nums[2] + nums[3] -> -4 + 1 + 2 -> -1
 *          if(|1 - -1| < |   |
 *
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        var closest = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            var start = i + 1;
            var end = nums.length - 1;

            while (start < end) {
                var curSum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - curSum) < Math.abs(target - closest)) {
                    closest = curSum;
                }
                if (curSum == target) return target;

                if (curSum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
