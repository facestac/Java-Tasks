package com.github.facestac;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    Task2 task2 = new Task2();

    @ParameterizedTest
    @MethodSource("generateData")
    void testIsContainsDuplicates(List<Integer> list) {
        assertTrue(task2.isContainsDuplicates(list));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 23, 4, 5, 5)),
                Arguments.of(List.of(1, 1)),
                Arguments.of(List.of(1, 2, 1)),
                Arguments.of(List.of(1, 1, 3, 3, 4)),
                Arguments.of(List.of(4, 5, 6, 6, 8))
        );
    }


    @ParameterizedTest
    @MethodSource("generateDataNotValid")
    void testIsNotContainsDuplicates(List<Integer> list) {
        assertFalse(task2.isContainsDuplicates(list));
    }

    static Stream<Arguments> generateDataNotValid() {
        return Stream.of(
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3, 4)),
                Arguments.of(List.of()),
                Arguments.of(List.of(4,5,6,7,8))
        );
    }
}