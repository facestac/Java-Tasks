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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task1 {
    private List<Integer> listNumbers = new ArrayList<>(List.of(8, 3, 15, 17));

    public static void main(String[] args) {
        Task1 task = new Task1();
        int compareNumber = 23;
        List<Integer> listIndexes = task.getIndexList(compareNumber);
        task.printResult(listIndexes);
    }

//    private void fillListNumbers() {
//    }

    private List<Integer> getIndexList(int compareNumber) {
        List<Integer> listIndexes = new ArrayList<>();

        // искомое число есть в списке - сразу возвращаем его индекс
        if (listNumbers.contains(compareNumber)) {
            listIndexes.add(listNumbers.indexOf(compareNumber));
            return listIndexes;
        }

        Collections.sort(listNumbers, Collections.reverseOrder());

        int sum = 0;
        List<Integer> listFounds = new ArrayList<>();
        boolean isFound = false;
        while (!isFound) {
            for (Integer num : listNumbers) {
                sum += num;
                if (sum == compareNumber) {
                    isFound = true;
                    break;
                } else if (sum > compareNumber) {

                }
            }
//            listFounds.add(listNumbers.get());
            printResult(listNumbers);
        }

        return listIndexes;
    }

    private void printResult(List<Integer> listIndexes) {
        System.out.println(listIndexes);
    }
}
