/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void getData() {
        TreeNode node = new TreeNode("Test");
        assertEquals("Test", node.getData());
    }

    @Test
    void setData() {
        TreeNode node = new TreeNode("Test");
        node.setData("Max");
        assertEquals("Max", node.getData());
    }

    @Test
    void getChildNodeLeft() {
        TreeNode node = new TreeNode("Test");
        TreeNode left = new TreeNode("Left");
        node.setChildNodeLeft(left);
        assertEquals(left, node.getChildNodeLeft());
    }

    @Test
    void setChildNodeLeft() {
        TreeNode node = new TreeNode("Test");
        TreeNode left = new TreeNode("Left");
        node.setChildNodeLeft(left);
        assertEquals(left, node.getChildNodeLeft());
    }

    @Test
    void getChildNodeRight() {
        TreeNode node = new TreeNode("Test");
        TreeNode right = new TreeNode("Right");
        node.setChildNodeRight(right);
        assertEquals(right, node.getChildNodeRight());
    }

    @Test
    void setChildNodeRight() {
        TreeNode node = new TreeNode("Test");
        TreeNode right = new TreeNode("Right");
        node.setChildNodeRight(right);
        assertEquals(right, node.getChildNodeRight());
    }

    @Test
    void testEquals() {
        TreeNode node1 = new TreeNode("Test");
        TreeNode node2 = new TreeNode("Test");
        TreeNode node3 = new TreeNode("Bingo");
        assertTrue(node1.equals(node2));
        assertFalse(node1.equals(node3));
    }

    @Test
    void testHashCode() {
        TreeNode node = new TreeNode("Test");
        assertEquals(2603186, node.hashCode());
    }

    @Test
    void testToString() {
        TreeNode node = new TreeNode("Test");
        TreeNode right = new TreeNode("Right");
        TreeNode left = new TreeNode("Left");
        node.setChildNodeRight(right);
        node.setChildNodeLeft(left);
        assertEquals("TreeNode{data='Test', childNodeLeft=TreeNode{data='Left', childNodeLeft=null, childNodeRight=null}, childNodeRight=TreeNode{data='Right', childNodeLeft=null, childNodeRight=null}}", node.toString());
    }
}