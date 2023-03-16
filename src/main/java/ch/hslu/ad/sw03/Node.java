/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

import java.util.Objects;

public class Node<T extends Comparable> {

    private final T data;
    private Node <T> left;
    private Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public T getData() {
        return data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public boolean isFull() {
        return this.left != null && this.right != null;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public void removeChild(final T element){
        if (Objects.equals(element, this.left.getData())){
            this.left = null;
        }
        if (Objects.equals(element, this.right.getData())){
            this.right = null;
        }
    }

    public void replaceChild(final Node<T> oldNode, final Node<T> newNode){
        if(oldNode == this.left){
            this.left = newNode;
        } else if(oldNode == this.right) {
            this.right = newNode;
        }
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
}
