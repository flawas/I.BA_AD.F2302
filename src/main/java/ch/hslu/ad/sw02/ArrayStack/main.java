/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw02.ArrayStack;

public class main {

    public static void main(String[] args) {
        ArrayStackInterface stackInterface = new ArrayStack();
        stackInterface.pushStackEelement(new ArrayStackElement("toll"));
        stackInterface.pushStackEelement(new ArrayStackElement("sind"));
        stackInterface.pushStackEelement(new ArrayStackElement("Datenstrukturen"));
        stackInterface.popStackElement();
        stackInterface.popStackElement();
        stackInterface.popStackElement();
    }
}
