package com.dsa.arraysstring.slidingwindow;

public class SubArrayFindLenght {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;
        System.out.println(find_lenght(nums,k));
    }

    private static int find_lenght(int[] nums, int k) {
        int left = 0;
        int curr = 0, answer = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }
            answer = Math.max(answer, right - left +1);
        }

        return answer;
    }
}
