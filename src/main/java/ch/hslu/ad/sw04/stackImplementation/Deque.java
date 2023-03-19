/*
 * Copyright Flavio Waser (c) 2023.
 */

package ch.hslu.ad.sw04.stackImplementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Deque implements StackInterface{

    private static int NUMBER_OF_ELEMENTS = 100000000;
    private static final Logger Log = LogManager.getLogger();
    private java.util.Deque<StackElement> deque;

    public static void main(String[] args) {
        Deque deque = new Deque();
        int temp = 1;
        long start = System.nanoTime();
        while (temp <= NUMBER_OF_ELEMENTS){
            deque.push(new StackElement("Test"));
            temp++;
        }
        long end = System.nanoTime();

        long elapsedTime = end - start;

        // TimeUnit
        long convert = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

        System.out.println(convert + " mili sekunden");
        System.out.print("Stack Size: " + deque.size());
    }

    public int size(){
        return deque.size();
    }

    @Override
    public void push(StackElement stackElement) {
        deque.push(stackElement);
    }

    @Override
    public StackElement pop() {
        if(deque.size() == 0) return null;
        return deque.pop();
    }

    @Override
    public boolean search(StackElement stackElement) {
        if(deque.size() == 0) return false;
        int temp = 0;
        while(temp <= deque.size()){
            if(deque.contains(stackElement)) {
                return true;
            }
            temp++;
        }
        return false;
    }
}
