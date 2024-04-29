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
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Task5 {
    public static void main(String[] args) {
        Task5 t = new Task5();
        List<Integer> exampleList = new ArrayList<>(List.of(1,3,5,6,7,8));

        System.out.println(t.getCorrectList(exampleList));
    }

    public List<Integer> getCorrectList(List<Integer> sourceList) {

       return sourceList.stream().collect(Collectors.collectingAndThen(
               Collectors.toList(),
                list -> IntStream.rangeClosed(list.get(0), list.get(list.size() - 1)).
                        boxed().
                        collect(Collectors.toList())
       ));
    }
}
