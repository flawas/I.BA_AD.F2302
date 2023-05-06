/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw10.heap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class FixedSizeHeapTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testInsertElement() {
        FixedSizeHeap heap = new FixedSizeHeap(16);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);

        assertEquals(6, heap.getUsedSize());
    }

    @Test
    public void testRemoveElement() {
        FixedSizeHeap heap = new FixedSizeHeap(16);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);

        heap.deleteMin();

        assertEquals(5, heap.getUsedSize());
    }

    @Test
    public void testReorganziseHeap() {
        FixedSizeHeap heap = new FixedSizeHeap(16);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);

        heap.deleteMin();

        assertEquals(7, heap.getMinChild());
    }

    @Test
    public void testHeapFull() {
        FixedSizeHeap heap = new FixedSizeHeap(6);
        heap.insert(20);
        heap.insert(10);
        heap.insert(5);
        heap.insert(12);
        heap.insert(7);
        heap.insert(50);
        heap.insert(10);

        exception.expect(IllegalStateException.class);
        heap.insert(100);
    }

    @Test
    public void testHeapEmpty() {
        FixedSizeHeap heap = new FixedSizeHeap(6);

        exception.expect(IllegalStateException.class);
        heap.deleteMin();
    }

}