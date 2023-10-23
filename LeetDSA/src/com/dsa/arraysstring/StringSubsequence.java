package com.dsa.arraysstring;

public class StringSubsequence {
    //A subsequence of a string is a sequence of characters that can be obtained by deleting some (or none) of the characters
// from the original string, while maintaining the relative order of the remaining characters.
// For example, "ace" is a subsequence of "abcde" while "aec" is not.
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println("START");

        String arr1 = "wada";
        String arr2 = "abcde";
        System.out.println(isSubsequence(arr1, arr2));

        System.out.println("END");
    }
}
