/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableItemTest {

    @Test
    void getData() {
        HashTableItem hashTableItem = new HashTableItem(1);
        assertEquals(1, hashTableItem.getData());
    }

    @Test
    void testEquals() {
        HashTableItem hashTableItem1 = new HashTableItem(1);
        HashTableItem hashTableItem2 = new HashTableItem(1);
        HashTableItem hashTableItem3 = new HashTableItem(2);
        assertTrue(hashTableItem2.equals(hashTableItem1));
        assertFalse(hashTableItem1.equals(hashTableItem3));
    }

    @Test
    void testHashCode() {
        HashTableItem hashTableItem1 = new HashTableItem(1);
        HashTableItem hashTableItem2 = new HashTableItem(1);
        assertEquals(hashTableItem1.hashCode(), hashTableItem2.hashCode());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(HashTableItem.class).verify();
    }
}