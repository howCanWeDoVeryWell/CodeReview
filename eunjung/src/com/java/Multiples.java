package com.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 10 미만의 자연수에서 3과 5의 배수를 구하면 3, 5, 6, 9이다. 이들의 총합은 23이다. 1000 미만의 자연수에서 3, 5의 배수의 총합을 구하라.
public class Multiples {
    private final int START_MULTIPLE_NUMBER = 1;
    private int maxNumber;
    
    public Multiples(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    
    public int getSumOfMultipleOfTwoNumbers(int firstNumber, int secondNumber) {
        Set<Integer> multipleSet = getResultMultipleValues(firstNumber, secondNumber);
        
        return multipleSet.stream().reduce((a, b) -> a + b).get();
    }
    
    public Set<Integer> getResultMultipleValues(int... numbers) {
        Set<Integer> resultMultipleSet = new HashSet<>();
        Arrays.stream(numbers).forEach(number -> {
            if (number != 0) {
                for (int i = number; i < maxNumber; i += number) {
                    resultMultipleSet.add(i);
                } 
            }
        });
        
        return resultMultipleSet;
    }
    
    public int getMaxNumber() {
        return this.maxNumber;
    }
    
    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
