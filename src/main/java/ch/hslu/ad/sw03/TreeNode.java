/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TreeNode {

    private String data;
    private TreeNode childNodeLeft;
    private TreeNode childNodeRight;
    private static final Logger Log = LogManager.getLogger();

    public TreeNode(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getChildNodeLeft() {
        return childNodeLeft;
    }

    public void setChildNodeLeft(TreeNode childNodeLeft) {
        this.childNodeLeft = childNodeLeft;
    }

    public TreeNode getChildNodeRight() {
        return childNodeRight;
    }

    public void setChildNodeRight(TreeNode childNodeRight) {
        this.childNodeRight = childNodeRight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode treeNode)) return false;

        return getData() != null ? getData().equals(treeNode.getData()) : treeNode.getData() == null;
    }

    @Override
    public int hashCode() {
        return getData() != null ? getData().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data='" + data + '\'' +
                ", childNodeLeft=" + childNodeLeft +
                ", childNodeRight=" + childNodeRight +
                '}';
    }
}
