/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void getLeft() {
        Node node1 = new Node("Root");
        node1.setLeft(new Node("Test"));
        assertEquals("Test", node1.getLeft().getData());
    }

    @Test
    void getData() {
        Node node = new Node("Test");
        assertEquals("Test", node.getData());
    }

    @Test
    void getRight() {
        Node node1 = new Node("Root");
        node1.setRight(new Node("Test"));
        assertEquals("Test", node1.getRight().getData());
    }

    @Test
    void isFull() {
        Node node1 = new Node("Root");
        Node nodeL = new Node("Left");
        Node nodeR = new Node("Right");
        node1.setRight(nodeR);
        node1.setLeft(nodeL);
        assertTrue(node1.isFull());
    }

    @Test
    void isLeaf() {
        Node node1 = new Node("Root");
        Node nodeL = new Node("Left");
        Node nodeR = new Node("Right");
        node1.setRight(nodeR);
        node1.setLeft(nodeL);
        assertTrue(node1.isFull());
    }

    @Disabled
    void removeChild() {
        Node node1 = new Node("Root");
        node1.setRight(new Node("Right"));
        node1.setLeft(new Node("Left"));
    }

    @Test
    void replaceChild() {
    }

    @Test
    void testToString() {
    }
}