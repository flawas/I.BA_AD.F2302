package ch.hslu.ad.sw02.ChainedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.List;

public class ChainedList {

    private static final Logger Log = LogManager.getLogger();

    private ListElement firstElement;
    private ListElement previousElement;

    public ChainedList() {
        Log.info("Generation ChainedList: " + this);
    }

    public void newNode(ListElement listElement){
        if(this.previousElement == null){
            this.firstElement = listElement;
            this.previousElement = listElement;
        } else {
            this.previousElement.setFollowingElement(listElement);
            this.previousElement = listElement;
        }
    }

    public ListElement getLastElement(){
        ListElement element = this.firstElement;
        while(element.getFollowingElement() != null){
            element = element.getFollowingElement();
        }
        return element;
    }

    public ListElement getLastElementRec(ListElement element){
        Log.debug(element.getData());
        if(element.getFollowingElement() != null){
            return this.getLastElementRec(element.getFollowingElement());
        }
        return element;
    }
}
