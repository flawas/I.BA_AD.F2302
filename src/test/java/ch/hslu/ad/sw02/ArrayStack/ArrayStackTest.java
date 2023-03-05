package ch.hslu.ad.sw02.ArrayStack;

import org.hamcrest.collection.ArrayAsIterableMatcher;
import org.junit.jupiter.api.Test;

import java.sql.Array;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void emptyStack(){
        ArrayStack stack = new ArrayStack();
        assertEquals(null, stack.popStackElement());
        assertTrue(stack.isStackEmpty());
    }

    @Test
    void addStackEelement() {
        ArrayStack stack = new ArrayStack();
        ArrayStackElement element = new ArrayStackElement("Test");
        stack.pushStackEelement(element);
        assertEquals("Test", stack.search(element).getData());
        assertFalse(stack.isStackEmpty());
    }

    @Test
    void removeStackElement() {
        ArrayStack stack = new ArrayStack();
        stack.pushStackEelement(new ArrayStackElement("Test 1"));
        stack.pushStackEelement(new ArrayStackElement("Test 2"));
        stack.pushStackEelement(new ArrayStackElement("Test 3"));
        stack.pushStackEelement(new ArrayStackElement("Test 4"));
        assertEquals("Test 4", stack.popStackElement().getData());
        assertEquals("Test 3", stack.popStackElement().getData());
        assertEquals("Test 2", stack.popStackElement().getData());
        assertEquals("Test 1", stack.popStackElement().getData());
    }

    @Test
    void search() {
        ArrayStack stack = new ArrayStack();
        stack.pushStackEelement(new ArrayStackElement("Test 1"));
        stack.pushStackEelement(new ArrayStackElement("Test 2"));
        stack.pushStackEelement(new ArrayStackElement("Test 3"));
        stack.pushStackEelement(new ArrayStackElement("Test 4"));
        assertEquals("Test 3", stack.search(new ArrayStackElement("Test 3")).getData());
    }

    @Test
    void pushStackEelement() {
    }

    @Test
    void popStackElement() {
    }

    @Test
    void testSearch() {
    }
}