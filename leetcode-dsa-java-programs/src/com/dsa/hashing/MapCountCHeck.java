package com.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class MapCountCHeck {

    public static int findLongestSubstring(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            while (counts.size() > k) {
                char remove = s.charAt(left);
                counts.put(remove, counts.getOrDefault(remove, 0) - 1);
                if (counts.get(remove) == 0) {
                    counts.remove(remove);
                }
                left++;
            }

            System.out.println("ans---------->"+ans);
            System.out.println("Right---------->"+right);
            System.out.println("left---------->"+left);
            System.out.println("------------------------------------------------------");
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("START");
        int k = 2;
        String ss = "eceba";
        findLongestSubstring(ss,k);
        System.out.println("END");
    }
}
