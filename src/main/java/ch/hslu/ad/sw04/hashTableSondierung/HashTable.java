/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.hashTableSondierung;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class HashTable implements HashTableInterface {

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
        if(!this.store.containsKey(getHashIndex(hashTableItem))){
            Log.info("Element " + hashTableItem.toString() + " an der Stelle " + getHashIndex(hashTableItem) + " eingefügt.");
            this.store.put(getHashIndex(hashTableItem),hashTableItem);
            return;
        }
        if(this.store.containsKey(getHashIndex(hashTableItem))){
            int tempIndex = getHashIndex(hashTableItem);
            while(this.store.get(tempIndex) != null){
                tempIndex++;
            }
            Log.info("Element " + hashTableItem.toString() + " an der Stelle " + tempIndex + " eingefügt.");
            this.store.put(tempIndex, hashTableItem);
        }
    }

    @Override
    public void remove(HashTableItem hashTableItem) {
        if(this.store.containsKey(getHashIndex(hashTableItem)) && this.store.get(getHashIndex(hashTableItem)).equals(hashTableItem)){
            this.store.remove(getHashIndex(hashTableItem));
            Log.info("Element " + hashTableItem.toString() + " wurde entfernt.");
            return;
        }
        if(this.store.containsKey(getHashIndex(hashTableItem))){
            int tempIndex = getHashIndex(hashTableItem);
            while(this.store.get(tempIndex) != null){
                if(this.store.get(tempIndex).equals(hashTableItem)){
                    Log.info("Element " + hashTableItem.toString() + " wurde entfernt.");
                    this.store.remove(tempIndex);
                    return;
                }
                tempIndex++;
            }
        }
    }

    @Override
    public HashTableItem serach(HashTableItem hashTableItem) {
        if(this.store.containsKey(getHashIndex(hashTableItem)) && this.store.get(getHashIndex(hashTableItem)).equals(hashTableItem)){
            Log.debug("Suche: " + hashTableItem.toString());
            return hashTableItem;
        }
        if(this.store.containsKey(getHashIndex(hashTableItem))){
            int tempIndex = getHashIndex(hashTableItem);
            while(this.store.get(tempIndex) != null){
                if(this.store.get(tempIndex).equals(hashTableItem)){
                    return this.store.get(tempIndex);
                }
                tempIndex++;
            }
        }
        return null;
    }


}
