/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void getHashIndex() {
        HashTable hashTable = new HashTable();
        assertEquals(1, hashTable.getHashIndex(new HashTableItem(10)));
    }

    @Test
    void hinzu() {
        HashTable hashTable = new HashTable();
        hashTable.hinzu(new HashTableItem(10));
        assertEquals(1, hashTable.size());
    }

    @Test
    void remove() {
        HashTable hashTable = new HashTable();
        hashTable.hinzu(new HashTableItem(10));
        hashTable.hinzu(new HashTableItem(5));
        hashTable.hinzu(new HashTableItem(7));
        hashTable.remove(new HashTableItem(10));
        hashTable.remove(new HashTableItem(7));
        assertEquals(1, hashTable.size());
    }

    @Test
    void serach() {
        HashTable hashTable = new HashTable();
        hashTable.hinzu(new HashTableItem(7));
        hashTable.hinzu(new HashTableItem(5));
        hashTable.hinzu(new HashTableItem(10));
        assertEquals(new HashTableItem(5), hashTable.serach(new HashTableItem(5)));
    }
}