package com.github.facestac;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task3Test {
    Task3 task3 = new Task3();

    @ParameterizedTest
    @ValueSource(strings = { "[()]{[]}", "()", "(())", "[({()})(())]", "[({})]", "[[({()}){[]}]()]" })
    void testIsLineValid(String str) {
        assertTrue(task3.isLineValid(str));

    }

    @ParameterizedTest
    @ValueSource(strings = { "(", ")())", "()[", "[])", "}{}())", "[({}])", "())" })
    void testIsNotLineValid(String str) {
        assertFalse(task3.isLineValid(str));

    }
}