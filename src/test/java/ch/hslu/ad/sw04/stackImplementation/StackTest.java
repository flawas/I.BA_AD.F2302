/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.stackImplementation;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push() {
        Stack stack = new Stack();
        stack.push(new StackElement("Test"));
        stack.push(new StackElement("Test"));
        assertEquals(2, stack.size());
    }

    @Test
    void pop() {
        Stack stack = new Stack();
        stack.push(new StackElement("Test 1"));
        stack.push(new StackElement("Test 2"));
        stack.push(new StackElement("Test 3"));
        stack.push(new StackElement("Test 4"));
        assertEquals(new StackElement("Test 4"), stack.pop());
    }

    @Test
    void search() {
        Stack stack = new Stack();
        stack.push(new StackElement("Test 1"));
        stack.push(new StackElement("Test 2"));
        stack.push(new StackElement("Test 3"));
        stack.push(new StackElement("Test 4"));
        assertEquals(true, stack.search(new StackElement("Test 2")));
    }
}