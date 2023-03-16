/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

import java.util.Objects;

public class HashNode<T extends Comparable<T>> {

    private final T data;
    private final int hash;
    private HashNode<T> left;
    private HashNode<T> right;

    public HashNode(final T data) {
        this.data = data;
        this.hash = data.hashCode();
    }
    
    public int getHash(){
        return this.hash;
    }

    public T getData() {
        return this.data;
    }

    public void setLeft(final HashNode<T> node) {
        this.left = node;
    }

    public void setRight(final HashNode<T> node) {
        this.right = node;
    }

    public HashNode<T> getLeft() {
        return this.left;
    }

    public HashNode<T> getRight() {
        return this.right;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean isFull() {
        return this.left != null && this.right != null;
    }

    public void removeChild(final T element) {
        if (Objects.equals(element, this.left.getData())) {
            this.left = null;
        } else if (Objects.equals((element), this.right.getData())) {
            this.right = null;
        }
    }
    
    public void replaceChild(final HashNode<T> oldNode, final HashNode<T> newNode){
       if (oldNode == this.left) {
            this.left = newNode;
        } else if (oldNode == this.right) {
            this.right = newNode;
        } 
    }

    @Override
    public String toString() {
        return "HashNode{" + "data=" + data + '}';
    }

}
