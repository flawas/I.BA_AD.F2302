/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class TreeIterator<T extends Comparable<T>> implements Iterator<T> {

    private Node<T> current;
    private final int size;
    private Stack<Node<T>> parents = new Stack<>();
    private Set<Node<T>> traversed = new HashSet<>();

    public TreeIterator(final Node<T> root, final int size){
        this.current = root;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return traversed.size() < this.size;
    }

    @Override
    public T next() {
        while(current.getLeft() != null && !traversed.contains(current.getLeft())){
            parents.add(current);
            current = current.getLeft();
        }
        if(!traversed.contains(current)) {
            traversed.add(current);
            return current.getData();
        }
        if(traversed.contains(current) && current.getRight() != null && !traversed.contains(current.getRight())) {
            parents.add(current);
            current = current.getRight();
            return this.next();
        }
        current = parents.pop();
        if(!traversed.contains(current)) {
            traversed.add(current);
            return current.getData();
        }
        return this.next();
    }
}
