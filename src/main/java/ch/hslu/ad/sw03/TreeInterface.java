/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw03;

public interface TreeInterface <T extends Comparable<T>> {

    /*
     * Add a element to the Tree
     */
    public boolean add(T element);

    /*
     * Remove a element from the tree
     */
    public boolean remove(T element);

    /*
     * Returns if an element exists in the tree
     */
    public boolean has(T element);


}
