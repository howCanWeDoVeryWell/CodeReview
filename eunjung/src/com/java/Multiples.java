package com.java;

import java.util.Arrays;
import java.util.List;

public class Multiples {
    private final int maxNumber;
    private final int baseNumber;
    private List<Integer> multipleSet;
    
    public Multiples(int maxNumber, int baseNumber) {
        this.maxNumber = maxNumber;
        this.baseNumber = baseNumber;
        this.multipleSet = Arrays.asList(3, 6, 9);
    }
    
    public int getMaxNumber() {
        return maxNumber;
    }
    
    public int getBaseNumber() {
        return baseNumber;
    }
    
    public List<Integer> getMultipleSet() {
        return this.multipleSet;
    }
}
