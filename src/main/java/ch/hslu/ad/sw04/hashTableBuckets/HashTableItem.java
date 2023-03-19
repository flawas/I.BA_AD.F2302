/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.hashTableBuckets;


import java.util.Objects;

public class HashTableItem {

    private final int data;
    private HashTableItem nextElement = null;
    private HashTableItem previousElement = null;


    public HashTableItem(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public HashTableItem getNextElement() {
        return nextElement;
    }

    public void setNextElement(HashTableItem nextElement) {
        this.nextElement = nextElement;
    }

    public HashTableItem getPreviousElement() {
        return previousElement;
    }

    public void setPreviousElement(HashTableItem previousElement) {
        this.previousElement = previousElement;
    }

    public boolean hasNextElement(){
        if(nextElement != null) return true;
        return false;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashTableItem that)) return false;

        return getData() == that.getData();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public final String toString() {
        return "HashTableItem{" +
                "data=" + data +
                '}';
    }
}
