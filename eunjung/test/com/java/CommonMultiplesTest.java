package com.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonMultiplesTest {
    private int maxNumber = 10;
    private int baseNumber = 3;
    private List<Integer> resultMultiples = Arrays.asList(3, 6, 9); 
    
    @Test
    public void testNewMultiple() {
        Multiples multiples = new Multiples(maxNumber, baseNumber);
        assertEquals(multiples.getMaxNumber(), maxNumber);
        assertEquals(multiples.getBaseNumber(), baseNumber);
    }
    
    @Test
    public void testMultiples() {
        Multiples multiples = new Multiples(maxNumber, baseNumber);
        assertArrayEquals(resultMultiples.toArray(), multiples.getMultipleSet().toArray());
    }
}