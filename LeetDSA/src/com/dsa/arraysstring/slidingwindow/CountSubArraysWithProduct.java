package com.dsa.arraysstring.slidingwindow;

public class CountSubArraysWithProduct {

    public static void main(String[] args) {
        System.out.println("START");

        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(countSubArraysWithProduct(nums,k));

        System.out.println("END");
    }

    private static int countSubArraysWithProduct(int[] nums, int k) {
        int ans = 0;
        if(k<=1)
            return ans;


        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++)
        {
            curr *=nums[right];
            while(curr >= k)
            {
                curr /= nums[left];
                left++;
            }

            ans += (right - left + 1);
        }
        return ans;
    }
}
