package com.dsa.arraysstring;

import java.util.ArrayList;
import java.util.List;

public class CombineTwoSortedArrays {

    private static List<Integer> combineTwoSortedArrays(Integer[] arr1, Integer[] arr2) {
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans.add(arr1[i]);
                i++;
            } else {
                ans.add(arr2[j]);
                j++;
            }
        }

        while (i < arr1.length) {
            ans.add(arr1[i]);
            i++;
        }

        while (j < arr2.length) {
            ans.add(arr2[j]);
            j++;
        }

        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("START");

        Integer arr1[] = {2, 8, 9, 19, 24};
        Integer arr2[] = {0, 1, 11, 55, 65};
        combineTwoSortedArrays(arr1, arr2);

        System.out.println("END");
    }
}
