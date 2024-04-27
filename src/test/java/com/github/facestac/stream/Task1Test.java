package com.github.facestac.stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    Task1 task = new Task1();

    @ParameterizedTest
    @MethodSource("generateDataTrue")
    void testTrue(String s) {
        assertTrue(task.isSameAmount(s));
    }

    static Stream<Arguments> generateDataTrue() {
        return Stream.of(
                Arguments.of("ooxx"),
                Arguments.of("ooxXm"),
                Arguments.of("zpzpzpp"),
                Arguments.of("")
        );
    }


    @ParameterizedTest
    @MethodSource("generateDataFalse")
    void testFalse(String s) {
        assertFalse(task.isSameAmount(s));
    }

    static Stream<Arguments> generateDataFalse() {
        return Stream.of(
                Arguments.of("xooxx"),
                Arguments.of("zzoo")
        );
    }
}
