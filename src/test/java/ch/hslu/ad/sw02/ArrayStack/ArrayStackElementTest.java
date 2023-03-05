/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw02.ArrayStack;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackElementTest {

    @Test
    void getData() {
        ArrayStackElement arrayStackElement = new ArrayStackElement("Test 1");
        assertEquals("Test 1", arrayStackElement.getData());
    }

    @Test
    void setData() {
        ArrayStackElement arrayStackElement = new ArrayStackElement("Test 1");
        arrayStackElement.setData("Test XY");
        assertEquals("Test XY", arrayStackElement.getData());
    }

    @Test
    void testEquals() {
        ArrayStackElement arrayStackElement1 = new ArrayStackElement("Test 1");
        ArrayStackElement arrayStackElement2 = new ArrayStackElement("Test 1");
        ArrayStackElement arrayStackElement3 = new ArrayStackElement("Test 3");
        assertTrue(arrayStackElement1.equals(arrayStackElement2));
        assertFalse(arrayStackElement1.equals(arrayStackElement3));
    }

    @Test
    void testHashCode() {
        ArrayStackElement arrayStackElement1 = new ArrayStackElement("Test 1");
        ArrayStackElement arrayStackElement2 = new ArrayStackElement("Test 1");
        ArrayStackElement arrayStackElement3 = new ArrayStackElement("Test 3");
        assertEquals(arrayStackElement1.hashCode(), arrayStackElement2.hashCode());
        assertFalse(arrayStackElement1.equals(arrayStackElement3));
    }
}