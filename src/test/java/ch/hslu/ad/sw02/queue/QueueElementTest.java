/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw02.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueElementTest {

    @Test
    void getData() {
        QueueElement queueElement  = new QueueElement('D');
        assertEquals('D', queueElement.getData());
    }

    @Test
    void setData() {
        QueueElement queueElement = new QueueElement('B');
        queueElement.setData('D');
        assertEquals('D', queueElement.getData());
    }

    @Test
    void testEquals() {
        QueueElement queueElement1 = new QueueElement('D');
        QueueElement queueElement2 = new QueueElement('D');
        QueueElement queueElement3 = new QueueElement('B');
        assertTrue(queueElement1.equals(queueElement2));
        assertFalse(queueElement1.equals(queueElement3));
    }

    @Test
    void testHashCode() {
        QueueElement queueElement1 = new QueueElement('D');
        QueueElement queueElement2 = new QueueElement('D');
        assertEquals(queueElement1.hashCode(), queueElement2.hashCode());
    }
}