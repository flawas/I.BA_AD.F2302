/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.hashTable;


public interface HashTableInterface {

    /*
     * Add a item to the hashtable
     */
    void hinzu(HashTableItem hashTableItem);

    /*
     * Remove a item of the hashtable
     */
    void remove(HashTableItem hashTableItem);

    /*
     * Search a item in the Hashtable
     */
    HashTableItem serach(HashTableItem hashTableItem);
}
