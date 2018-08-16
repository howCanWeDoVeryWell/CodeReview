package com.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonMultiplesTest {
    private final int maxNumber = 10;
    @Test
    public void testNewCommonMultiple() {
        CommonMultiples commonMultiples = new CommonMultiples(maxNumber);
        assertEquals(commonMultiples.getMaxNumber(), maxNumber);
    }
}