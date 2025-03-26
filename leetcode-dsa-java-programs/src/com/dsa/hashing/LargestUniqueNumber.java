package com.dsa.hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LargestUniqueNumber {

    public static void main(String[] args) {
        System.out.println("START");
        int[] nums = {5,7,3,9,4,9,8,3,1};
        System.out.println("LargestUniqueNumber is---------->"+largestUniqueNumber(nums));
        System.out.println("END");
    }

    private static int largestUniqueNumber(int[] nums) {

        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(num->num,Collectors.counting()));
        Optional<Integer> ans = map.entrySet().stream().filter(entry->entry.getValue()==1).map(Map.Entry::getKey).max(Comparator.naturalOrder());
        return ans.orElse(-1);
    }
}
