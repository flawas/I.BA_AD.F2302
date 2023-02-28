package ch.hslu.ad.sw02.ChainedList;

import net.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainedListTest {

    @Test
    void newNode() {
        ChainedList chainedList = new ChainedList();
        chainedList.newNode(new ListElement());
        assertEquals(1, chainedList.getLastElement());
    }

    @Test
    void getLastElement() {
        ChainedList chainedList = new ChainedList();
        chainedList.newNode(new ListElement());
        chainedList.newNode(new ListElement());
        chainedList.newNode(new ListElement());
        assertEquals(1, chainedList.getLastElement());
    }

    @Test
    void getSize() {
        ChainedList chainedList = new ChainedList();
        chainedList.newNode(new ListElement());
        chainedList.newNode(new ListElement());
        chainedList.newNode(new ListElement());
        assertEquals(3, chainedList.getSize());
    }
}