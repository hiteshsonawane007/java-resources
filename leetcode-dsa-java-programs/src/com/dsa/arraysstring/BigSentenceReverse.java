package com.dsa.arraysstring;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BigSentenceReverse {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        String ss=Stream.of(s.split(" ")).map (elem -> new StringBuilder(elem).reverse()).collect(Collectors.joining(" "));
        System.out.println(ss);
    }
}
