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
    private final static Map<Character, Character> BRACKETS = Map.of('{', '}', '(', ')', '[', ']');


    public static void main(String[] args) {
        final String exampleString = "{[]{()}}(";
        Task3 task = new Task3();
        System.out.println(task.isLineValid(exampleString));

    }

    public boolean isLineValid(String str) {
        if (str.isEmpty()) return true;

        Deque<Character> deque = new LinkedList<>();

        for (Character ch : str.toCharArray()) {
            if (BRACKETS.containsKey(ch)) {
                deque.push(ch);
            } else {
                if (deque.isEmpty()) return false;

                char openBracket = deque.pop();
                if (BRACKETS.get(openBracket) != ch) return false;
            }
        }

        return deque.isEmpty();
    }


}
