package com.github.facestac;

/*
Дан список целых чисел.
Необходимо реализовать метод, которые определяет, содержит ли данный список дубликаты

Пример:
List: [4,5,6,6,8]
Result: true
Число 6 повторяется 2 раза

List: [4,5,6,7,8]
Result: false
Дубликатов нет
 */


import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        Task2 task = new Task2();
        List<Integer> listNumbers = new ArrayList<>(List.of(4,5,8,8));


        System.out.println(task.isContainsDuplicates(listNumbers));
    }

    public boolean isContainsDuplicates(List<Integer> list) {
        Set<Integer> set = convertListToSet(list);
        return (list.size() != set.size());
    }

    private Set<Integer> convertListToSet(List<Integer> listNumbers) {
        return (new HashSet<>(listNumbers));
    }

}
