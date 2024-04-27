package com.github.facestac.stream;


/*
Take 2 strings s1 and s2 including only letters from a to z.
Return a new sorted string, the longest possible, containing distinct
letters - each taken only once - coming from s1 or s2.

Examples:
a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"

a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
 */

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task4 {
    public static void main(String[] args) {
        Task4 t = new Task4();
        String a = "xyaabbbccccdefww";
        String b = "xxxxyyyyabklmopq";

        System.out.println(t.convertJadenCasedString(a, b));
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
