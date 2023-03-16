/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

import java.util.Iterator;

public class Tree<T extends Comparable<T>> implements TreeInterface<T>, Iterable {

    private Node<T> root;
    private int size;

    @Override
    public boolean add(T element) {
        if(this.has(element)){
            return false;
        }
        if(this.root == null){
            this.root = new Node<>(element);
        } else {
            Node<T> parent = this.findNewParent(this.root, element);
            if (parent.getData().compareTo(element) > 0) {
                parent.setLeft(new Node<>(element));
            } else {
                parent.setRight(new Node<>(element));
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        Node<T> toRemove = this.find(this.root, element);
        if(toRemove == null){
            return false;
        }
        if(toRemove == this.root) {
            if(toRemove.isLeaf()) {
                this.root = null;
            } else if(toRemove.isFull()){
                throw new UnsupportedOperationException("Not supported yet.");
            } else {
                if (toRemove.getLeft() != null){
                    this.root = toRemove.getLeft();
                } else {
                    this.root = toRemove.getRight();
                }
            }
        } else {
            Node<T> oldParent = this.getParent(this.root, toRemove);
            if(toRemove.isLeaf()){
                oldParent.removeChild(element);
            } else if(toRemove.isFull()){
                throw new UnsupportedOperationException("Not supported yet.");
            } else {
                if(toRemove.getLeft() != null) {
                    oldParent.replaceChild(toRemove, toRemove.getLeft());
                } else {
                    oldParent.replaceChild(toRemove, toRemove.getRight());
                }
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean has(T element) {
        return this.find(this.root, element) != null;
    }

    public Node<T> findNewParent(final Node<T> current, T element) {
        Node<T> next = this.getNext(current, element);
        if (next != null) {
            return findNewParent(next, element);
        }
        return current;
    }

    private Node<T> getNext(final Node<T> current, final T target) {
        if (current.getData().compareTo(target) > 0) {
            return current.getLeft();
        }
        if (current.getData().compareTo(target) < 0) {
            return current.getRight();
        }
        return null;
    }

    public Node<T> find(final Node<T> current, T element){
        if (current == null){
            return null;
        }
        if(current.getData().compareTo(element) == 0){
            return current;
        }
        Node<T> next = this.getNext(current,element);
        return find(next, element);
    }

    public Node<T> getParent(final Node<T> current, final Node<T> child){
        if (current.getLeft() == child){
            return current;
        }
        if(current.getRight() == child){
            return current;
        }
        Node<T> next = this.getNext(current, child.getData());
            if(next != null){
                return getParent(next, child);
            }
            return null;
        }

    @Override
    public Iterator iterator() {
        return new TreeIterator(this.root, this.size);
    }
}
