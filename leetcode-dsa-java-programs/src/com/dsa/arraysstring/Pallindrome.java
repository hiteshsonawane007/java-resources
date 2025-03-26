package com.dsa.arraysstring;

public class Pallindrome {

    public static boolean checkIfPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPalindrome("Nitin"));
    }
}
