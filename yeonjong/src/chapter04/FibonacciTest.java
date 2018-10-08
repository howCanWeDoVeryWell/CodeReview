package chapter04;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    //1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987
    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void testGetTermBy() {
        assertEquals(1, fibonacci.getTermBy(0, 1, 1));
        assertEquals(1, fibonacci.getTermBy(0, 1, 2));
        assertEquals(2, fibonacci.getTermBy(0, 1, 3));
        assertEquals(3, fibonacci.getTermBy(0, 1, 4));
        assertEquals(5, fibonacci.getTermBy(0, 1, 5));
        assertEquals(8, fibonacci.getTermBy(0, 1, 6));
        assertEquals(13, fibonacci.getTermBy(0, 1, 7));
        assertEquals(21, fibonacci.getTermBy(0, 1, 8));
        assertEquals(34, fibonacci.getTermBy(0, 1, 9));
    }

}