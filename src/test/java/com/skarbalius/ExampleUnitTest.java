package com.skarbalius;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleUnitTest {

    @Test
    void addition_isCorrect() {
        Main main = new Main();
        assertEquals(4, main.add(2, 2));
    }
}
