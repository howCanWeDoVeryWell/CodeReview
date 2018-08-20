package com.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PagingTest {
    @Test
    public void testGetTotalPageCount() {
        Paging paging = new Paging();
        Assertions.assertEquals(0, paging.getTotalPageCount(0, 0));
        Assertions.assertEquals(1, paging.getTotalPageCount(1, 1));
        Assertions.assertEquals(2, paging.getTotalPageCount(2, 1));
        Assertions.assertEquals(2, paging.getTotalPageCount(3, 2));
        Assertions.assertEquals(4, paging.getTotalPageCount(10, 3));
    }
}
