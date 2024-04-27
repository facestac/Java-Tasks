package com.github.facestac.collections;

/*
Дана строка состоящия из символов (){}[]. Строка является валидной, если каждая
открывающая скобка корректно закрывается. Необходимо определить является ли строка валидной

Пример:
String: [()]{[]}
Result: true
Все корректно

Пример: [({}])
Result: false
Скобка ] закрывает до закрытия скобки )

Пример: ())
Result: false
Скобка ) не открывалась
 */

import java.util.*;

public class Task3 {
    private final static String OPEN_BRACKETS = "{[(";
    private final static String CLOSE_BRACKETS = "}])";


    public static void main(String[] args) {
        final String exampleString = "{[]{()}}(";
        Task3 task = new Task3();
        System.out.println(task.isLineValid(exampleString));

        System.out.println(task.isLineValid_v2(exampleString));
    }

    public boolean isLineValid(String str) {
        if (str.isEmpty()) return true;
        if (!isEvenLineCount(str)) return false;
        if (!isValidLastCharacter(str)) return false;

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch =  str.charAt(i);
//            System.out.println(ch);

            if (isOpenBracket(ch)) {
                deque.push(ch);
                continue;
            }

            if (isCloseBracket(ch)) {
                if (deque.isEmpty()) return false;
                char openBracket = deque.pop();
                if (getBracketType(openBracket) != getBracketType(ch)) return false;
            }

        }

        return deque.isEmpty();
    }

    private boolean isEvenLineCount(String str) {
        return (str.length() % 2 == 0);
    }

    private boolean isValidLastCharacter(String str) {
        return isCloseBracket(str.charAt(str.length() - 1));
    }

    private boolean isOpenBracket(Character ch) {
        return (OPEN_BRACKETS.contains(ch.toString()));
    }

    private boolean isCloseBracket(Character ch) {
        return (CLOSE_BRACKETS.contains(ch.toString()));
    }

    private int getBracketType(Character ch) {
        return switch (ch) {
            case '(', ')' -> 0;
            case '[', ']' -> 1;
            default -> 2;
        };
    }



    // version 2
    public boolean isLineValid_v2(String str) {
        char[] charArray = str.toCharArray();

        Deque<Character> deque = new LinkedList<>();
        for (char c : charArray) {
            deque.add(c);
        }

//        System.out.println(deque);
        ListIterator<Character> iterator = (ListIterator<Character>) deque.iterator();

        while (iterator.hasNext()) {
            Character first = iterator.next();
            if (isOpenBracket(first)) {
                Character second = ' ';
                if (iterator.hasNext()) second = iterator.next();
                if (isCloseBracket(second)) {

                    if (getBracketType(first) == getBracketType(second)) {
                        iterator.remove();
                        iterator.previous();
                        iterator.remove();
                        if (iterator.hasPrevious()) iterator.previous();
                    }
                } else {
                    iterator.previous();
                }
            }

        }
//        System.out.println(deque);


        return deque.isEmpty();
    }
}
