package com.dsa.arraysstring;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        //int[] nums = {3,2,4};
        int target = -8;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
