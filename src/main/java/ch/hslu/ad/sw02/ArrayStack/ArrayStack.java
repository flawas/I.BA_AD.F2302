package ch.hslu.ad.sw02.ArrayStack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.LinkedList;

public class ArrayStack implements ArrayStackInterface{

    private static final Logger Log = LogManager.getLogger();

    private final LinkedList<ArrayStackElement> stack = new LinkedList<>();

    public ArrayStack() {
        Log.info("ArrayStack generiert.");
    }

    /* --------------------------------------------------------------------------------
     * Hilfsmethoden
     * --------------------------------------------------------------------------------
     */
    public boolean isStackEmpty(){
        if (this.stack.isEmpty()) return true;
        return false;
    }


    /* --------------------------------------------------------------------------------
     * Override-Methoden
     * --------------------------------------------------------------------------------
     */

    @Override
    public void pushStackEelement(ArrayStackElement element) {
        Log.debug("pushStackEelement: " + element.getData());
        this.stack.push(element);
    }

    @Override
    public ArrayStackElement popStackElement(){

        if(!(this.stack.size() > 0)){
            Log.error("popStackElement: Size 0!");
            return null;
        }

        Log.debug("popStackElement: " + toString());
        return this.stack.pop();
    }

    @Override
    public ArrayStackElement search(ArrayStackElement element){
        for(int i = 0; i <= stack.size(); i++){
            if(this.stack.get(i).equals(element)){
                Log.debug("searchResult: " + this.stack.get(i).getData());
                return this.stack.get(i);
            }
        }
        Log.error("searchResult: null return!");
        return null;
    }

    @Override
    public int getSize() {
        return this.stack.size();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "stack=" + stack +
                '}';
    }
}
