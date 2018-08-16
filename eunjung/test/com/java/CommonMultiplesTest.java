package com.java;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonMultiplesTest {
    private int maxNumber = 10;
    private int startNum = 3;
    private List<Integer> resultMultiples = Arrays.asList(3, 6, 9); 
    
    @Test
    public void testNewMultiple() {
        Multiples multiples = new Multiples(maxNumber);
        assertEquals(multiples.getMaxNumber(), maxNumber);
    }
    
    @Test
    public void testMultipleSet() {
        Multiples multiples = new Multiples(maxNumber);
        assertArrayEquals(resultMultiples.toArray(), multiples.getResultMultipleSet(startNum).toArray());
        
        maxNumber = 20;
        resultMultiples = Arrays.asList(3, 6, 9, 12, 15, 18);
        Multiples multiples2 = new Multiples(maxNumber);
        assertArrayEquals(resultMultiples.toArray(), multiples2.getResultMultipleSet(startNum).toArray());
    }
}