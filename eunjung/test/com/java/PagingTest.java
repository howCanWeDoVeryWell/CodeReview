package com.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PagingTest {
    @Test
    public void testGetTotalPageCount() {
        // Given
        Paging paging = new Paging();
        int totalListCount = 0;
        int countOfOnePage = 0;
        
        // When
        int result = paging.getTotalPageCount(totalListCount, countOfOnePage);
        
        // Then
        Assertions.assertEquals(0, result);
        
        
        // Given
        totalListCount = 1;
        countOfOnePage = 1;
        
        // When
        result = paging.getTotalPageCount(totalListCount, countOfOnePage);
        
        // Then
        Assertions.assertEquals(1, result);
    
    
        // Given
        totalListCount = 2;
        countOfOnePage = 1;
    
        // When
        result = paging.getTotalPageCount(totalListCount, countOfOnePage);
    
        // Then
        Assertions.assertEquals(2, result);
    
    
        // Given
        totalListCount = 3;
        countOfOnePage = 2;
    
        // When
        result = paging.getTotalPageCount(totalListCount, countOfOnePage);
    
        // Then
        Assertions.assertEquals(2, result);
    
    
        // Given
        totalListCount = 10;
        countOfOnePage = 3;
    
        // When
        result = paging.getTotalPageCount(totalListCount, countOfOnePage);
    
        // Then
        Assertions.assertEquals(4, result);
    }
}
