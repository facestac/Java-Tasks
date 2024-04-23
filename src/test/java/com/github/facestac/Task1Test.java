package com.github.facestac;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    Task1 task1 = new Task1();


    @ParameterizedTest
    @MethodSource("generateData")
    void testgeTElementsFromList(List<Integer> list, int compareValue, List<Integer> indexes) {
        assertEquals(task1.getElementsFromList(list, compareValue), indexes);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(3), 3, List.of(0)),
                Arguments.of(List.of(1, 23, 4, 6, 5), 23, List.of(1)),
                Arguments.of(List.of(1, 2), 3, List.of(0, 1)),
                Arguments.of(List.of(8, 2, 1), 9, List.of(0, 2)),
                Arguments.of(List.of(1, 3, 4, 13, 19), 18, List.of(0, 2, 3)),
                Arguments.of(List.of(3, 8, 15, 17), 23, List.of(1, 2))
        );
    }


}