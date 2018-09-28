package com.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplesTest {
    @Test
    public void testGetSumOfMultipleOfTwoNumbers() {
        // Given
        int maxNumber = 10;
        Multiples multiples = new Multiples(maxNumber);

        // When
        int resultNumber = multiples.getMultipleSumBy(0, 1);

        // Then
        assertEquals(45, resultNumber);

        // When
        resultNumber = multiples.getMultipleSumBy(1, 2);

        // Then
        assertEquals(45, resultNumber);

        // When
        resultNumber = multiples.getMultipleSumBy(3, 5);

        // Then
        assertEquals(23, resultNumber);


        // Given
        multiples = new Multiples(1000);

        // When
        resultNumber = multiples.getMultipleSumBy(3, 5);

        // Then
        assertEquals(233168, resultNumber);
    }
}