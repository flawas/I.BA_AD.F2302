/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.hashTableBuckets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTable implements HashTableInterface{

    private Map<Integer, HashTableItem> store = new HashMap<>();
    private static final Logger Log = LogManager.getLogger();

    public int getHashIndex(HashTableItem hashTableItem){
        return hashTableItem.hashCode() % 10;
    }
    @Override
    public void add(HashTableItem hashTableItem) {
        if(!this.store.containsKey(getHashIndex(hashTableItem))){
            this.store.put(getHashIndex(hashTableItem), hashTableItem);
            Log.info("Neues Element: " + hashTableItem + " wurde an Stelle " + getHashIndex(hashTableItem) + " eingefügt.");
            return;
        }
        if(this.store.containsKey(getHashIndex(hashTableItem))){
            // Es existiert noch keine Kette
            if(!this.store.get(getHashIndex(hashTableItem)).hasNextElement()){
                this.store.get(getHashIndex(hashTableItem)).setNextElement(hashTableItem);
                hashTableItem.setPreviousElement(this.store.get(getHashIndex(hashTableItem)));
                Log.info("Neues Element: " + hashTableItem + " wurde an das Element " + hashTableItem.getPreviousElement() + " verknüpft.");
                return;
            }
            HashTableItem tempIndex = this.store.get(getHashIndex(hashTableItem));
            while(tempIndex.getNextElement() != null){
                tempIndex = tempIndex.getNextElement();
            }
            tempIndex.setNextElement(hashTableItem);
            hashTableItem.setPreviousElement(tempIndex);
            Log.info("Neues Element: " + hashTableItem + " wurde an das Element " + hashTableItem.getPreviousElement() + " verknüpft.");
        }
    }

    @Override
    public HashTableItem search(HashTableItem hashTableItem) {
        if(this.store.containsKey(getHashIndex(hashTableItem))){
            if(this.store.get(getHashIndex(hashTableItem)).equals(hashTableItem)){
                return hashTableItem;
            }
            if(this.store.get(getHashIndex(hashTableItem)).hasNextElement()){
                HashTableItem tempIndex = this.store.get(getHashIndex(hashTableItem));
                for(int i = -1; i <= store.size(); i++){
                    Log.debug(tempIndex);
                    if(tempIndex.equals(hashTableItem)){
                        return hashTableItem;
                    }
                    Log.debug("Next Element: "  + tempIndex.getNextElement());
                    tempIndex = tempIndex.getNextElement();
                }
            }
        }
        return null;
    }

    @Override
    public void remove(HashTableItem hashTableItem) {
        if(this.store.containsKey(getHashIndex(hashTableItem))){
            // wenn das erste Element in der Liste gelöscht werden soll
            if(this.store.get(getHashIndex(hashTableItem)).equals(hashTableItem)){
                if(this.store.get(getHashIndex(hashTableItem)).hasNextElement()){
                    HashTableItem newIndex = this.store.get(getHashIndex(hashTableItem)).getNextElement();
                    this.store.get(getHashIndex(hashTableItem)).getNextElement().setPreviousElement(null);
                    this.store.put(getHashIndex(hashTableItem), newIndex);
                }
                this.store.remove(hashTableItem);
                return;
            }
            // wenn das n-te Element in der Liste gelöscht werden soll
            HashTableItem nElement = this.store.get(getHashIndex(hashTableItem));
            while(this.store.get(getHashIndex(nElement)).hasNextElement()){
                if(nElement.equals(hashTableItem)){
                    if(nElement.getNextElement() != null){
                        nElement.getPreviousElement().setNextElement(nElement.getNextElement());
                        nElement.getNextElement().setPreviousElement(nElement.getPreviousElement());
                    } else {
                        nElement.getPreviousElement().setNextElement(null);
                    }

                    Log.info("Element: " + hashTableItem + " wurde entfernt");
                    return;
                }
                nElement = nElement.getNextElement();
           }
        }
    }
}
