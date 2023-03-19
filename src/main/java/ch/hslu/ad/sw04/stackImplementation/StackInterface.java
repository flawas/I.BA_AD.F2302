/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.stackImplementation;

public interface StackInterface{

    /*
     * add to stack
     */
    void push(StackElement stackElement);

    /*
     * delete from stack
     */
    StackElement pop();

    /*
     * search if element exists in stack
     */
    boolean search(StackElement stackElement);

}
