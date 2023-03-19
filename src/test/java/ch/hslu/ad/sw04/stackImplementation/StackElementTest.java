/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.stackImplementation;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackElementTest {



    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(StackElement.class).verify();
    }


    @Test
    void getData() {
        StackElement stackElement = new StackElement("Test");
        assertEquals("Test", stackElement.getData());
    }

    @Test
    void testToString() {
        StackElement stackElement = new StackElement("Test");
        assertEquals("StackElement{data='Test'}", stackElement.toString());
    }

    @Test
    void testEquals() {
        StackElement stackElement1 = new StackElement("Test");
        StackElement stackElement2 = new StackElement("Test");
        StackElement stackElement3 = new StackElement("Wrong");
        assertTrue(stackElement1.equals(stackElement2));
        assertFalse(stackElement1.equals(stackElement3));
    }

    @Test
    void testHashCode() {
        StackElement stackElement = new StackElement("Test");
        assertEquals(2603186, stackElement.hashCode());
    }
}