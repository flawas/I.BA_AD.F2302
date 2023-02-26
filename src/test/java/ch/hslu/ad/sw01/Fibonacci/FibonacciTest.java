package ch.hslu.ad.sw01.Fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void fiboRec1() {
        assertEquals(3, Fibonacci.fiboRec1(4));
        assertEquals(55, Fibonacci.fiboRec1(10));
    }

    @Test
    void fiboRec2(){
        assertEquals(3, Fibonacci.fiboRec2(4));
        assertEquals(3, Fibonacci.fiboRec2(4));
    }
}