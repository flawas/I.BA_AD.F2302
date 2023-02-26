package ch.hslu.ad.sw01.Zahlen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZahlenTest {

    @Test
    void checkSymmetric() {
        assertEquals(true, Zahlen.checkSymmetric(11));
        assertFalse(Zahlen.checkSymmetric(5234));
    }

    @Test
    void findSymmetric() {
        assertEquals(505, Zahlen.findSymmetric(500));
        assertEquals(7, Zahlen.findSymmetric(7));
    }
}