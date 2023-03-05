/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw02.ArrayStack;

public interface ArrayStackInterface {
    void pushStackEelement(ArrayStackElement element);

    ArrayStackElement popStackElement();

    ArrayStackElement search(ArrayStackElement element);

    int getSize();
}
