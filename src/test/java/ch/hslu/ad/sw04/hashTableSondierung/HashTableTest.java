/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.hashTableSondierung;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void hinzu() {
        HashTable hashTable = new HashTable();
        hashTable.hinzu(new HashTableItem(10));
        hashTable.hinzu(new HashTableItem(10));
        hashTable.hinzu(new HashTableItem(10));
        assertEquals(3, hashTable.size());
    }

    @Test
    void remove() {
        HashTable hashTable = new HashTable();
        hashTable.hinzu(new HashTableItem(10));
        hashTable.hinzu(new HashTableItem(100));
        hashTable.hinzu(new HashTableItem(50));
        hashTable.remove(new HashTableItem(100));
        assertEquals(2, hashTable.size());
    }

    @Test
    void serach() {
        HashTable hashTable = new HashTable();
        hashTable.hinzu(new HashTableItem(10));
        hashTable.hinzu(new HashTableItem(100));
        hashTable.hinzu(new HashTableItem(20));
        assertEquals(new HashTableItem(20), hashTable.serach(new HashTableItem(20)));
    }

    @Test
    void hashes(){
        HashTable hashTable = new HashTable();
        System.out.println(hashTable.getHashIndex(new HashTableItem(10)));
        System.out.println(hashTable.getHashIndex(new HashTableItem(100)));
        System.out.println(hashTable.getHashIndex(new HashTableItem(25)));
    }
}