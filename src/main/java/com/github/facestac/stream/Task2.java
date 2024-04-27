package com.github.facestac.stream;


/*
Welcome. In this kata, you are asked to square every digit of
a number and concatenate them.

For example, if we run 9119 through the function, 811181 will come out,
because 92 is 81 and 12 is 1. (81-1-1-81)

Example #2: An input of 765 will/should return 493625 because
72 is 49, 62 is 36, and 52 is 25. (49-36-25)

Note: The function accepts an integer and returns an integer.

Happy Coding!
 */

import java.util.Arrays;
import java.util.stream.Collectors;


public class Task2 {
    public static void main(String[] args) {
        Task2 t = new Task2();
        int testNumber = 9124;
        System.out.println(t.getSquareDigits(testNumber));
    }

    public int getSquareDigits(Integer num) {
        String str = Arrays.stream(String.valueOf(num).split(""))
                .map(Integer::parseInt)
                .map(x -> x * x)
                .map(Object::toString)
                .collect(Collectors.joining());

        return Integer.parseInt(str);


//        return Arrays.stream(String.valueOf(num).split(""))
//                 .map(Integer::parseInt)
//                 .map(x -> x * x)
//                 .map(Object::toString)
//                 .reduce((x, y) -> x + y)
//                 .map(Integer::parseInt)
//                 .get();
    }


}