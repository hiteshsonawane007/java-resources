package com.dsa.arraysstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquaresSortedArray {
    public static Object[] sortedSquares(int[] nums) {
        List<Integer> lst = new ArrayList<Integer>();

        for (int i: nums) {
            //System.out.println(i);
            lst.add(i*i);
        }
        return Arrays.stream(lst.stream().toArray()).sorted().toArray();
    }

    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        for (int i =0; i < n; i++)
            ans[i] = nums[i] *nums[i];

        Arrays.sort(ans);
        return ans;
    }

    public static int[] sortedSquares3(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int left = 0;
        int right = n-1;

        //-4,-1,0,3,10
        for (int i = n-1; i >= 0; i--)
        {
            int square;
            if(Math.abs(nums[left]) < Math.abs(nums[right]))
            {
                square = nums[right];
                right--;
            }
            else
            {
                square = nums[left];
                left++;
            }
            ans[i] = square*square;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("START");
        int [] arr = {-4,-1,0,3,10};
        //Arrays.stream(sortedSquares(arr)).forEach(o -> System.out.println(o.toString()));
        int[] arr2 = sortedSquares3(arr);
        for (int k: arr2) {
            System.out.println(k);
        }
        System.out.println("END");
    }
}
