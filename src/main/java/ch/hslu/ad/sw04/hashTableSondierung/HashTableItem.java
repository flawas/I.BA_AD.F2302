/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.hashTableSondierung;

import java.util.Objects;

public class HashTableItem {

    private final int data;

    public HashTableItem(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof HashTableItem p) && (Objects.equals(p.data, this.data));
    }

    @Override
    public final int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "HashTableItem{" +
                "data=" + data +
                '}';
    }
}
