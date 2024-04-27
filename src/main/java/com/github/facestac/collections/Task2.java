package com.github.facestac.collections;

/*
Task2.1
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
        List<Integer> exampleList = new ArrayList<>(List.of(8, 8, 23, 23, 8, 4, 4, 4, 23, 4,5,8,8));

        System.out.println(task.isContainsDuplicates(exampleList));

        Map<Integer, Integer> map = task.getNumberOfDuplicates(exampleList);
        task.printNumberOfDuplicates(map);

        Map<Integer, Integer> sortedMap = task.getSortedMap(map);
        task.printNumberOfDuplicates(sortedMap);
    }

    public boolean isContainsDuplicates(List<Integer> list) {
        Set<Integer> set = convertListToSet(list);

        return (list.size() != set.size());
    }

    private Set<Integer> convertListToSet(List<Integer> listNumbers) {
        return (new HashSet<>(listNumbers));
    }

    /*
    Task2.2
    Дополнительно: Вывести сообщение какой дубликат сколько раз встречается
    */
    private Map<Integer, Integer> getNumberOfDuplicates(List<Integer> list) {
        Set<Integer> set = convertListToSet(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer key : set) {
            int duplicates = Collections.frequency(list, key);
            if (duplicates > 1) {
                map.put(key, duplicates);
            }
        }

        return map;
    }

    private void printNumberOfDuplicates(Map<Integer, Integer> map) {
        map.forEach((k, v) -> System.out.println("number " + k + " repeats : " + v + " times"));
        System.out.println();
    }


    /*
    Task2.3
    Дополнительно: вывести в отсортированном порядке, по возрастанию значения
    дубликата (не количеству повторений)
    */
    private Map<Integer, Integer> getSortedMap(Map<Integer, Integer> map) {
        return new TreeMap<>(map);
    }
}
