/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashTable implements HashTableInterface{

    private Map<Integer, HashTableItem> store = new HashMap<>();
    private static final Logger Log = LogManager.getLogger();

    public int getHashIndex(HashTableItem hashTableItem){
        return hashTableItem.hashCode() % 10;
    }

    public int size(){
        return store.size();
    }

    @Override
    public void hinzu(HashTableItem hashTableItem) {
        if(!(this.store.containsKey(getHashIndex(hashTableItem)))){
            this.store.put(getHashIndex(hashTableItem), hashTableItem);
            Log.info(hashTableItem.toString() + store.toString());
        } else {
            Log.error("Es existiert ein Element an dieser Stelle.");
        }
    }

    @Override
    public void remove(HashTableItem hashTableItem) {
        if(this.store.containsKey(getHashIndex(hashTableItem)) && this.store.get(getHashIndex(hashTableItem)).equals(hashTableItem)){
            this.store.remove(getHashIndex(hashTableItem));
            Log.info("Element " + hashTableItem.toString() + " wurde entfernt.");
        }
    }

    @Override
    public HashTableItem serach(HashTableItem hashTableItem) {
        if(this.store.containsKey(getHashIndex(hashTableItem)) && this.store.get(getHashIndex(hashTableItem)).equals(hashTableItem)){
            Log.debug("Suche: " + hashTableItem.toString());
            return hashTableItem;
        }

        return null;
    }


}
