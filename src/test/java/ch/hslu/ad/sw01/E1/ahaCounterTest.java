package ch.hslu.ad.sw01.E1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ahaCounterTest {

    @Test
    void setCount() {
        ahaCounter counter = new ahaCounter();
        counter.setCount(10);
        assertEquals(10, counter.getCount());
    }

    @Test
    void setCountPlusOne() {
        ahaCounter counter = new ahaCounter();
        counter.setCountPlusOne();
        assertEquals(1, counter.getCount());
    }

    @Test
    void getCount() {
        ahaCounter counter = new ahaCounter();
        counter.setCount(5);
        assertEquals(5, counter.getCount());
    }
}