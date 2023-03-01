package ch.hslu.ad.sw02.ChainedList;

import net.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainedListTest {

    @Test
    void newNode() {
        ChainedList chainedList = new ChainedList();
        chainedList.newNode(new ListElement("Test"));
        assertEquals(1, chainedList.getLastElement());
    }

    @Test
    void getLastElement() {
        ChainedList chainedList = new ChainedList();
        chainedList.newNode(new ListElement("Flavio"));
        chainedList.newNode(new ListElement("Linus"));
        chainedList.newNode(new ListElement("Claudio"));
        assertEquals("Claudio", chainedList.getLastElement().getData());
    }

    @Test
    void getLastElementRec(){
        ChainedList chainedList = new ChainedList();
        ListElement firstElement = new ListElement("Flavio");
        chainedList.newNode(firstElement);
        chainedList.newNode(new ListElement("Linus"));
        chainedList.newNode(new ListElement("Claudio"));
        assertEquals("Claudio", chainedList.getLastElementRec(firstElement).getData());
    }

}