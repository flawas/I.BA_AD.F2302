/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw02.queue;

public class QueueElement {

    private char data;

    public QueueElement(char data) {
        this.data = data;
    }

    /* --------------------------------------------------------------------------------
     * getter-Methoden
     * --------------------------------------------------------------------------------
     */

    public char getData() {
        return data;
    }

    /* --------------------------------------------------------------------------------
     * setter-Methoden
     * --------------------------------------------------------------------------------
     */

    public void setData(char data) {
        this.data = data;
    }

    /* --------------------------------------------------------------------------------
     * Override-Methoden
     * --------------------------------------------------------------------------------
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QueueElement that)) return false;

        return getData() == that.getData();
    }

    @Override
    public int hashCode() {
        return getData();
    }
}
