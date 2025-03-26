package com.dsa.arraysstring;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoArraysCombineAndSort {
    public static <T> void main(String[] args) {
        System.out.println("START");
        Integer arr1[] = {2,5,7,9,2,55,67};
        Integer arr2[] = {44,55,88,99,77,0,1};

        ArrayList<Integer> arrlist;
        arrlist = (ArrayList<Integer>) Arrays.stream(Stream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).toArray(size -> (T[]) Array.newInstance(arr1.getClass().getComponentType(), size))).collect(Collectors.toList());
        System.out.println(arrlist);

        System.out.println("END");
    }
}
