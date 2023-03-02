package ch.hslu.ad.sw02.ChainedList;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.lang.invoke.CallSite;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListElementTest {

    @Test
    void getData() {
        ListElement listElement = new ListElement("Test");
        assertEquals("Test", listElement.getData());
    }

    @Test
    void getFollowingElement() {
        ListElement listElement = new ListElement("Test");
        ListElement followingElement = new ListElement("Follower");
        listElement.setFollowingElement(followingElement);
        assertEquals(followingElement, listElement.getFollowingElement());
    }

    @Test
    void setFollowingElement() {
        ListElement listElement = new ListElement("Max");
        ListElement followingElement = new ListElement("Moritz");
        listElement.setFollowingElement(followingElement);
        assertEquals(followingElement, listElement.getFollowingElement());
    }

    @Test
    void testEquals() {
        ListElement t1 = new ListElement("Max");
        ListElement t2 = new ListElement("Max");
        assertTrue(t1.equals(t2));
    }

    @Test
    void testHashCode() {
        ListElement listElement = new ListElement("TestHashCode");
        ListElement listElement2 = new ListElement("TestHashCode XY");
        assertEquals(1752296052, listElement.hashCode());
        assertFalse(listElement.equals(listElement2));
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.simple();
    }
}