package com.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonMultiplesTest {
    private int maxNumber = 10;
    private int startNum = 3;
    private Multiples multiples = new Multiples(maxNumber);
    
    @Test
    public void testNewMultiple() {
        assertEquals(multiples.getMaxNumber(), maxNumber);
    }
    
    @Test
    public void testGetResultMultipleSet() {
        int [] resultMultiples = new int[] {3, 6, 9}; 
        assertArrayEquals(resultMultiples, multiples.getResultMultipleSet(startNum));
        
        maxNumber = 20;
        resultMultiples = new int[] {3, 6, 9, 12, 15, 18};
        Multiples multiples2 = new Multiples(maxNumber);
        assertArrayEquals(resultMultiples, multiples2.getResultMultipleSet(startNum));
    }
    
    @Test
    public void testGetSumOfMultipleOfTwoNumbers() {
        int resultNumber = multiples.getSumOfMultipleOfTwoNumbers(0, 1);
        assertEquals(45, resultNumber);
        
        resultNumber = multiples.getSumOfMultipleOfTwoNumbers(1, 2);
        assertEquals(45, resultNumber);
        
        resultNumber = multiples.getSumOfMultipleOfTwoNumbers(3, 5);
        assertEquals(23, resultNumber);
        
        multiples.setMaxNumber(1000);
        resultNumber = multiples.getSumOfMultipleOfTwoNumbers(3, 5);
        assertEquals(233168, resultNumber);
    }
}