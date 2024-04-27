package com.github.facestac.stream;


/*
Check to see if a string has the same amount of 'x's and 'o's.
The method must return a boolean and be case insensitive.
The string can contain any char.

Examples input/output:

XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false
 */

public class Task1 {
    public static void main(String[] args) {
        Task1 t = new Task1();
        String testString = "";
        System.out.println(t.isSameAmount(testString));
    }

    public boolean isSameAmount(String s) {
        long countX = getCountOfChar(s, 'x');
        long countO = getCountOfChar(s, 'o');

        return countX == countO;
    }

    private long getCountOfChar(String s, char ch) {
        return s.chars()
                .map(Character::toLowerCase)
                .filter(x-> x == ch)
                .count();
    }
}
