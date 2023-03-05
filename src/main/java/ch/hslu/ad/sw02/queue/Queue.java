/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw02.queue;

import ch.hslu.ad.sw02.ChainedList.ListElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Queue implements QueueInterface {

    private QueueElement head;
    private QueueElement tail;
    private static final Logger Log = LogManager.getLogger();
    private static int maxQueueSize = 8;

    public Queue() {
        Log.debug("Queue erstellt: ");
    }

    /* --------------------------------------------------------------------------------
     * getter-Methoden
     * --------------------------------------------------------------------------------
     */


    public QueueElement getHead() {
        Log.debug("getHead: " + head.getData());
        return head;
    }

    public QueueElement getTail() {
        Log.debug("getTail: " + tail.getData());
        return tail;
    }

    /* --------------------------------------------------------------------------------
     * Override-Methoden
     * --------------------------------------------------------------------------------
     */

    @Override
    public void enqueue(final QueueElement queueElement){
        if(this.head == null){
            this.head = queueElement;
            this.tail = queueElement;
            Log.debug("first queueElement" + queueElement.toString());
            return;
        }

        if(getQueueSize() >= maxQueueSize){
            Log.error("Queue ist voll!");
            return;
        }

        if(this.head != null){
            this.tail.setFollowingElement(queueElement);
            queueElement.setPreviousElement(this.tail);
            this.tail = queueElement;
            Log.debug("new queueElement" + queueElement.toString() + " head: " + this.head + " tail: " + this.tail);
        }
    }

    @Override
    public void dequeue() {
        if(this.getQueueSize() == 0) {
            Log.error("Queue ist leer. ");
            return;
        }
        QueueElement newHead = this.head.getFollowingElement();
        QueueElement oldElement = this.head;
        if(newHead != null) {
            this.head = newHead;
            Log.debug("dequeue QueueElement" + oldElement.toString());
            return;
        }
        if(newHead == null){
            Log.debug("dequeue QueueElement" + oldElement.toString());
            Log.info("Queue ist leer.");
            this.head = null;
        }
    }

    @Override
    public int getQueueSize(){
        if(this.head == null) return 0;
        QueueElement element = this.head;
        int counter = 0;
        while(element.getFollowingElement() != null){
            counter++;
            element = element.getFollowingElement();
        }
        if(element.equals(getTail())){
            counter++;
        }
        Log.debug("Anzahl Elemente: " + counter);
        return counter;
    }



}
