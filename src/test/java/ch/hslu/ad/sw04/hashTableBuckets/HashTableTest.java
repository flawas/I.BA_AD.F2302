/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.hashTableBuckets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void add() {
        HashTable hashTable = new HashTable();
        hashTable.add(new HashTableItem(10));
        hashTable.add(new HashTableItem(100));
        hashTable.add(new HashTableItem(20));
    }

    @Test
    void search() {
        HashTable hashTable = new HashTable();
        hashTable.add(new HashTableItem(10));
        hashTable.add(new HashTableItem(100));
        hashTable.add(new HashTableItem(20));
        assertEquals(new HashTableItem(20), hashTable.search(new HashTableItem(20)));
    }

    @Test
    void removeMiddle() {
        HashTable hashTable = new HashTable();
        hashTable.add(new HashTableItem(10));
        hashTable.add(new HashTableItem(100));
        hashTable.add(new HashTableItem(20));
        hashTable.remove(new HashTableItem(100));
    }

    @Test
    void removeFirst() {
        HashTable hashTable = new HashTable();
        hashTable.add(new HashTableItem(10));
        hashTable.add(new HashTableItem(100));
        hashTable.add(new HashTableItem(20));
        hashTable.remove(new HashTableItem(10));
    }

    @Test
    void removeLast() {
        HashTable hashTable = new HashTable();
        hashTable.add(new HashTableItem(10));
        hashTable.add(new HashTableItem(100));
        hashTable.add(new HashTableItem(20));
        hashTable.remove(new HashTableItem(20));
    }
}