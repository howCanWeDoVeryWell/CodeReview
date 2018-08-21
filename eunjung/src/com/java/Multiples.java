package com.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Multiples {
    private int maxNumber;
    
    public Multiples(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    
    public int getMaxNumber() {
        return maxNumber;
    }
    
    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    
    public int [] getResultMultipleSet(int startNumber) {
        int setSize = getMultipleSetSize(startNumber);
        int [] resultMultipleSet = new int[setSize];
        
        int multipleNumber = startNumber;
        for (int i = 0; i < setSize; i++) {
            resultMultipleSet[i] = (multipleNumber);
            multipleNumber += startNumber;
        }
        
        return resultMultipleSet;
    }
    
    private int getMultipleSetSize(int startNumber) {
        int setSize = 0;
        if (startNumber > 0) {
            setSize = maxNumber / startNumber;
            if (maxNumber % setSize == 0) {
                setSize--;
            }
        }
        return setSize;
    }
    
    public int getSumOfMultipleOfTwoNumbers(int firstNumber, int secondNumber) {
        int [] firstNumberMultipleSet = getResultMultipleSet(firstNumber);
        int [] secondNumberMultipleSet = getResultMultipleSet(secondNumber);
    
        int firstSumNumberOfMultiple = Arrays.stream(firstNumberMultipleSet).sum();
        int secondSumnumberOfMultiple = Arrays.stream(secondNumberMultipleSet).filter(secondNum -> 
            IntStream.of(firstNumberMultipleSet).noneMatch(firstNum -> firstNum == secondNum)
        ).sum();
        return firstSumNumberOfMultiple + secondSumnumberOfMultiple;
    }
}
