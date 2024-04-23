package com.github.facestac;

/*
Дан список целых чисел. Необходимо реализовать метод, который возвращает индексы списка,
значения которых в сумме дают число переданное в метод.

Предполагается, что список содержит только уникальные числа и всегда имеет искомые числа.
Один и тот же элемент не может быть использован дважды.

List = [3, 8, 15, 17], Number = 23
result = [1,2]

Т.е. индексы 1 и 2 (значение 8 и 15) в сумме дают искомое число 23
 */

import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        Task1 task = new Task1();
        List<Integer> listNumbers = new ArrayList<>(List.of(15, 2, 3, 17, 8, 45));
        int compareNumber = 23;
        System.out.println(task.getElementsFromList(listNumbers, compareNumber));


//        System.out.println(indexes);
    }


    public List<Integer> getElementsFromList(List<Integer> sourceList, int sourceNumber) {
        // копируем и сортируем список по убыванию
        List<Integer> listNumbers = new ArrayList<>(sourceList);
        listNumbers.sort(Collections.reverseOrder());
//        System.out.println(listNumbers);

        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int lastIndex = i;
        int compareNumber = sourceNumber;

        while (lastIndex < listNumbers.size()) {
            if (compareNumber > 0) {
                int currentValue = listNumbers.get(i);
                deque.push(currentValue);
                compareNumber -= currentValue;
                i++;
            } else if (!deque.isEmpty()){
                compareNumber += deque.pop();
            }

            if (compareNumber == 0) {
                List<Integer> indexes = getIndexesFromValues(sourceList, deque);
                Collections.sort(indexes);
                return indexes;
            }

            if (i == listNumbers.size() ) {
//                while (!deque.isEmpty()) compareNumber += deque.pop();
                deque.clear();
                compareNumber = sourceNumber;
                lastIndex++;
                i = lastIndex;
            }
        }

        return null;
    }

    private List<Integer> getIndexesFromValues(List<Integer> list, Deque<Integer> values) {
        List<Integer> indexes = new ArrayList<>();

        for (Integer value : values) {
            indexes.add(list.indexOf(value));
        }

        return indexes;
    }

}
