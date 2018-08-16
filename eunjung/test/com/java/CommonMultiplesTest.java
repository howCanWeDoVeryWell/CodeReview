package com.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonMultiplesTest {
    private final int maxNumber = 10;
    @Test
    public void testNewMultiple() {
        Multiples multiples = new Multiples(maxNumber);
        assertEquals(multiples.getMaxNumber(), maxNumber);
    }
}