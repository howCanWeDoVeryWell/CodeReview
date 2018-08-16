package com.java;

import java.util.ArrayList;
import java.util.List;

public class Multiples {
    private final int maxNumber;
    
    public Multiples(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    
    public int getMaxNumber() {
        return maxNumber;
    }

    public List<Integer> getResultMultipleSet(int startNumber) {
        List<Integer> resultMultipleSet = new ArrayList<Integer>();
        int multipleNumber = startNumber;
        while (multipleNumber < maxNumber) {
            resultMultipleSet.add(multipleNumber);
            multipleNumber += startNumber;
        }
        return resultMultipleSet;
    }
    
    public int getSumOfMultipleOfTwoNumbers(int firstNumber, int secondNumber) {
        return 0;
    }
}
