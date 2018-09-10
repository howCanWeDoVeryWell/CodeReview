    package com.java;
    
    import org.junit.jupiter.api.Test;

    import java.util.HashSet;
    import java.util.Set;

    import static org.junit.jupiter.api.Assertions.*;
    
    class MultiplesTest {
        @Test
        public void testNewMultiple() {
            int maxNumber = 10;
            Multiples multiples = new Multiples(maxNumber);
            
            assertEquals(multiples.getMaxNumber(), maxNumber);
        }
        
        @Test
        public void testGetResultMultipleSetForOneNumber() {
            // Given
            int firstMultipleNum = 3;
            int maxNumber = 10;
            Multiples multiples = new Multiples(maxNumber);
            Set<Integer> resultMultiples = new HashSet<>();
            resultMultiples.add(3);
            resultMultiples.add(6);
            resultMultiples.add(9);

            // When
            Set<Integer> testMultiples = multiples.getResultMultipleValues(firstMultipleNum);

            // Then
            assertArrayEquals(resultMultiples.toArray(), testMultiples.toArray());
        }
        
        @Test
        public void testGetResultMultipleSetForTwoNumber() {
            // Given
            int firstMultipleNum = 3;
            int secondMultipleNum = 2;
            int maxNumber = 10;
            Multiples multiples = new Multiples(maxNumber);
            Set<Integer> resultMultiples = new HashSet<>();
            resultMultiples.add(2);
            resultMultiples.add(3);
            resultMultiples.add(4);
            resultMultiples.add(6);
            resultMultiples.add(8);
            resultMultiples.add(9);
    
            // When
            Set<Integer> testMultiples = multiples.getResultMultipleValues(firstMultipleNum, secondMultipleNum);
    
            // Then
            assertArrayEquals(resultMultiples.toArray(), testMultiples.toArray());
    
        }
        
        @Test
        public void testGetSumOfMultipleOfTwoNumbers() {
            // Given
            int maxNumber = 10;
            Multiples multiples = new Multiples(maxNumber);
    
            // When
            int resultNumber = multiples.getSumOfMultipleOfTwoNumbers(0, 1);
    
            // Then
            assertEquals(45, resultNumber);
    
            // When
            resultNumber = multiples.getSumOfMultipleOfTwoNumbers(1, 2);
    
            // Then
            assertEquals(45, resultNumber);
    
            // When
            resultNumber = multiples.getSumOfMultipleOfTwoNumbers(3, 5);

            // Then
            assertEquals(23, resultNumber);
    
    
            // Given
            multiples.setMaxNumber(1000);
    
            // When
            resultNumber = multiples.getSumOfMultipleOfTwoNumbers(3, 5);
    
            // Then
            assertEquals(233168, resultNumber);
        }
    }