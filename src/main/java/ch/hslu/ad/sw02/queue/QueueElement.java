/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw02.queue;

public class QueueElement {

    private char data;
    private QueueElement followingElement;
    private QueueElement previousElement;

    public QueueElement(final char data) {
        this.data = data;
    }

    /* --------------------------------------------------------------------------------
     * getter-Methoden
     * --------------------------------------------------------------------------------
     */

    public char getData() {
        return data;
    }

    public QueueElement getFollowingElement(){
        return followingElement;
    }

    public QueueElement getPreviousElement(){
        return previousElement;
    }

    /* --------------------------------------------------------------------------------
     * setter-Methoden
     * --------------------------------------------------------------------------------
     */

    public void setData(final char data) {
        this.data = data;
    }

    public void setFollowingElement(QueueElement element){
        this.followingElement = element;
    }

    public void setPreviousElement(final QueueElement element){
        this.previousElement = element;
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

    @Override
    public String toString() {
        return "QueueElement{" +
                "data=" + data +
                '}';
    }
}
