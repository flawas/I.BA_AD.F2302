package ch.hslu.ad.sw02.ChainedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class ChainedList extends ListElement {

    private static final Logger Log = LogManager.getLogger();
    private int chainedListSize;

    public ChainedList() {
        Log.info("Generation ChainedList: " + this);
        this.chainedListSize = 0;
    }

    public void newNode(ListElement listElement){
        this.chainedListSize++;
        Log.info("newNode: " + listElement);
        Log.debug(this + " followingElement " + listElement);
        setFollowingElement(listElement);
        getLastElement();
    }

    public ListElement getLastElement(){
        while(followingElement != null){
            Log.info("getLastElement: " + followingElement);
            return followingElement;
        }
        Log.info("adf");
        return followingElement;
    }

    public int getSize(){
        return chainedListSize;
    }
}
