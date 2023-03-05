/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw02.queue;

public interface QueueInterface {

    /*
     * ein QueueElement in die Queue hinzufügen
     */
    void enqueue(final QueueElement queueElement);

    /*
     * ein QueueElement aus der Queue entfernen
     */
    void dequeue();

    /*
     * die aktuelle Grösse der Queue abfragen
     */
    int getQueueSize();


}
