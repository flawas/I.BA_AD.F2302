/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.hashTableBuckets;

public interface HashTableInterface {

    /*
     * add to hashtable
     */
    void add(HashTableItem hashTableItem);

    /*
     * search in hashtable
     */
    HashTableItem search(HashTableItem hashTableItem);

    /*
     * remove from hashtable
     */
    void remove(HashTableItem hashTableItem);
}
