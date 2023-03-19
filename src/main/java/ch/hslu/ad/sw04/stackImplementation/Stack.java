/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.stackImplementation;

import ch.hslu.ad.sw02.ArrayStack.ArrayStackElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Stack implements StackInterface {

    private static int NUMBER_OF_ELEMENTS = 100000000;
    private static final Logger Log = LogManager.getLogger();
    private final java.util.Stack<StackElement> stack = new java.util.Stack<>();

    public static void main(String[] args) {
        Stack stack = new Stack();
        int temp = 1;
        long start = System.nanoTime();
        while (temp <= NUMBER_OF_ELEMENTS){
            stack.push(new StackElement("Test"));
            temp++;
        }
        long end = System.nanoTime();

        long elapsedTime = end - start;

        // TimeUnit
        long convert = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

        System.out.println(convert + " mili sekunden");
        System.out.print("Stack Size: " + stack.size());
    }

    public int size(){
        return stack.size();
    }

    @Override
    public void push(StackElement stackElement) {
        stack.add(stackElement);
    }

    @Override
    public StackElement pop() {
        if(stack.size() == 0) return null;
        return stack.pop();
    }

    @Override
    public boolean search(StackElement stackElement) {
        if(stack.size() == 0) return false;
        int temp = 0;
        while(temp <= stack.size()){
            if(stack.get(temp).equals(stackElement)) {
                return true;
            }
            temp++;
        }
        return false;
    }
}
