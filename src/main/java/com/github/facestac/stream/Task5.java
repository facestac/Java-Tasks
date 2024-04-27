package com.github.facestac.stream;


/*
Issue
Looks like some hoodlum plumber and his brother has been running
around and damaging your stages again.

The pipes connecting your level's stages together need to be fixed
before you receive any more complaints.

The pipes are correct when each pipe after the first is 1 more than the previous one.

Task
Given a list of unique numbers sorted in ascending order, return a new list so
that the values increment by 1 for each index from the minimum value up
to the maximum value (both included).

Example
Input:  1,3,5,6,7,8 Output: 1,2,3,4,5,6,7,8
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task5 {
    public static void main(String[] args) {
        Task5 t = new Task5();
        List<Integer> lisr = new ArrayList<>(List.of(1,3,5,6,7,8));

//        System.out.println(t.convertJadenCasedString(a, b));
    }

    public String convertJadenCasedString(String s1, String s2) {
        Stream<String> stream1 = Arrays.stream(s1.split(""));
        Stream<String> stream2 = Arrays.stream(s2.split(""));

        return Stream.concat(stream1, stream2)
                .distinct()
                .sorted()
                .collect(Collectors.joining());
    }


}
