/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw02.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {


    @Test
    void getHead() {
        Queue queue = new Queue();
        queue.enqueue(new QueueElement('A'));
        assertEquals('A', queue.getHead().getData());
    }

    @Test
    void getTail() {
        Queue queue = new Queue();
        queue.enqueue(new QueueElement('A'));
        queue.enqueue(new QueueElement('B'));
        queue.enqueue(new QueueElement('C'));
        queue.enqueue(new QueueElement('D'));
        assertEquals('D', queue.getTail().getData());
    }

    @Test
    void enqueue() {
        Queue queue = new Queue();
        queue.enqueue(new QueueElement('A'));
        queue.enqueue(new QueueElement('B'));
        queue.enqueue(new QueueElement('C'));
        queue.enqueue(new QueueElement('D'));
        assertEquals('D', queue.getTail().getData());
    }

    @Test
    void dequeue() {
        Queue queue = new Queue();
        queue.enqueue(new QueueElement('A'));
        queue.enqueue(new QueueElement('B'));
        queue.enqueue(new QueueElement('C'));
        queue.enqueue(new QueueElement('D'));
        queue.dequeue();
        assertEquals('B', queue.getHead().getData());
    }

    @Test
    void dequeueToEmpty(){
        Queue queue = new Queue();
        queue.enqueue(new QueueElement('A'));
        queue.dequeue();
        assertEquals(0, queue.getQueueSize());
    }

    @Test
    void dequeueEmpty(){
        Queue queue = new Queue();
        queue.dequeue();
    }

    @Test
    void getQueueSize() {
        Queue queue = new Queue();
        queue.enqueue(new QueueElement('A'));
        queue.enqueue(new QueueElement('B'));
        queue.enqueue(new QueueElement('C'));
        queue.enqueue(new QueueElement('D'));
        assertEquals(4, queue.getQueueSize());
    }

    @Test
    void getQueueSizeOverflow(){
        Queue queue = new Queue();
        queue.enqueue(new QueueElement('A'));
        queue.enqueue(new QueueElement('B'));
        queue.enqueue(new QueueElement('C'));
        queue.enqueue(new QueueElement('C'));
        queue.enqueue(new QueueElement('D'));
        queue.enqueue(new QueueElement('E'));
        queue.enqueue(new QueueElement('F'));
        queue.enqueue(new QueueElement('G'));
        queue.enqueue(new QueueElement('H'));
        assertEquals(8, queue.getQueueSize());

    }
}