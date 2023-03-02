package ch.hslu.ad.sw02.ChainedList;

import com.sun.net.httpserver.Filter;
import net.bytebuddy.asm.MemberSubstitution;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainedListTest {

    @Test
    void newNode() {
        ChainedList chainedList = new ChainedList();
        ListElement newNode = new ListElement("Test");
        chainedList.newNode(newNode);
        assertEquals(newNode.getData(), chainedList.getLastElement().getData());
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

    @Test
    void getFirstElementAndRemove(){
        ChainedList chainedList = new ChainedList();
        chainedList.newNode(new ListElement("Linus"));
        chainedList.newNode(new ListElement("Flavio"));
        assertEquals("Linus", chainedList.getFirstElementAndRemove().getData());
        assertEquals("Flavio", chainedList.getLastElement().getData());
    }

    @Test
    void getChainedListSize(){
        ChainedList chainedList = new ChainedList();
        chainedList.newNode(new ListElement("Test 1"));
        chainedList.newNode(new ListElement("Test 2"));
        assertEquals(2, chainedList.getChainedListSize());
    }

    @Test
    void removeElementFirst(){
        ChainedList chainedList = new ChainedList();
        ListElement removeElement = new ListElement("Test zu löschen");
        chainedList.newNode(removeElement);
        chainedList.newNode(new ListElement("Test 1"));
        chainedList.newNode(new ListElement("Test 1"));
        chainedList.newNode(new ListElement("Test 2"));
        chainedList.newNode(new ListElement("Test 3"));
        chainedList.removeElement(removeElement);
        assertEquals(3, chainedList.getChainedListSize());
    }

    @Test
    void removeElementEnd(){
        ChainedList chainedList = new ChainedList();
        ListElement removeElement = new ListElement("Test zu löschen");
        chainedList.newNode(new ListElement("Test 1"));
        chainedList.newNode(new ListElement("Test 2"));
        ListElement lastNewElement = new ListElement("Test 3");
        chainedList.newNode(lastNewElement);
        chainedList.newNode(removeElement);
        chainedList.removeElement(removeElement);
        assertEquals(3, chainedList.getChainedListSize());
        assertEquals(lastNewElement.getData(), chainedList.getLastElement().getData());
    }

    @Test
    void removeElementAny(){
        ChainedList chainedList = new ChainedList();
        ListElement removeElement = new ListElement("Test zu löschen");
        ListElement test1 = new ListElement("Test 1");
        chainedList.newNode(test1);
        ListElement test2 = new ListElement("Test 2");
        chainedList.newNode(test2);
        chainedList.newNode(removeElement);
        ListElement test3 = new ListElement("Test 3");
        chainedList.newNode(test3);
        chainedList.removeElement(removeElement);
        assertEquals(3, chainedList.getChainedListSize());
        assertEquals(test1.getFollowingElement(), test2);
        assertEquals(test2.getFollowingElement(), test3);
    }

    @Test
    void removeElementNotExisting(){
        ChainedList chainedList = new ChainedList();
        chainedList.newNode(new ListElement("Test 1"));
        chainedList.newNode(new ListElement("Test 2"));
        chainedList.newNode(new ListElement("Test 3"));
        ListElement removeElement = new ListElement("Test zu löschen");
        chainedList.removeElement(removeElement);
        assertEquals(1, chainedList.getChainedListSize());
    }

    @Test
    void getPreviousElement(){
        ChainedList chainedList = new ChainedList();
        chainedList.newNode(new ListElement("Test 1"));
        ListElement element1 = new ListElement("Test 2");
        chainedList.newNode(element1);
        ListElement element2 = new ListElement("Test 3");
        chainedList.newNode(element2);
        assertEquals(element1, chainedList.getPreviousElement(element2));
    }

    @Test
    void searchElement(){
        ChainedList chainedList = new ChainedList();
        ListElement searchElement = new ListElement("SearchElement");
        chainedList.newNode(new ListElement("Test 1"));
        chainedList.newNode(new ListElement("Test 2"));
        chainedList.newNode(searchElement);
        chainedList.newNode(new ListElement("Test 3"));
        assertEquals(searchElement, chainedList.searchElement(searchElement));
    }

}