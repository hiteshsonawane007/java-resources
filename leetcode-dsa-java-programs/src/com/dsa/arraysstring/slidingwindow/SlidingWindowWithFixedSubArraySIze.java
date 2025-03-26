package com.dsa.arraysstring.slidingwindow;

public class SlidingWindowWithFixedSubArraySIze {

    public static void main(String[] args) {
        System.out.println("START");
        int[] nums = {3,-1,4,12,-8,5,6};
        int k = 4;
        System.out.println("Maximum sum with Array size with "+k+"  is---->"+findBestSubArray(nums,k));
        System.out.println("END");
    }

    private static int findBestSubArray(int[] nums, int k) {
        int curr = 0;
        for (int i=0;i<k;i++)
            curr +=nums[i];

        int ans = curr;
        for (int i=k;i<nums.length;i++)
        {
            curr += nums[i] - nums[i-k];
            ans = Math.max(ans,curr);
        }

        return ans;
    }
}
