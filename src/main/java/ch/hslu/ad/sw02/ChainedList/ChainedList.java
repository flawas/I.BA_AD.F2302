package ch.hslu.ad.sw02.ChainedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;

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
            Log.info("newNode (firstElement): " + listElement.getData());
        } else {
            this.previousElement.setFollowingElement(listElement);
            this.previousElement = listElement;
            Log.info("newNode: " + listElement.getData());
        }
    }

    public ListElement getLastElement(){
        ListElement element = this.firstElement;
        while(element.getFollowingElement() != null){
            element = element.getFollowingElement();
        }
        Log.debug("Letzer Node: " + element.getData());
        return element;
    }

    public ListElement getLastElementRec(ListElement element){
        Log.debug(element.getData());
        if(element.getFollowingElement() != null){
            return this.getLastElementRec(element.getFollowingElement());
        }
        Log.debug("Letzer Node (rec): " + element.getData());
        return element;
    }

    public ListElement getPreviousElement(ListElement listElement){
        ListElement element = this.firstElement;
        ListElement previousElement = null;
        while(!element.equals(listElement)){
            previousElement = element;
            Log.info("New previousElement: " + previousElement.getData());
            element = element.getFollowingElement();
        }
        Log.debug("Vorheriger Node: " + previousElement.getData());
        return previousElement;
    }

    public ListElement searchElement(ListElement searchElement){
        ListElement element = this.firstElement;
        while (!element.equals(searchElement)) {
            element = element.getFollowingElement();
        }
        Log.debug("Gesuchter Node: " + element.getData());
        return element;
    }

    public int getChainedListSize(){
        ListElement element = this.firstElement;
        int counter = 0;
        while(element.getFollowingElement() != null){
            counter++;
            element = element.getFollowingElement();
        }
        if(element.equals(getLastElement())){
            counter++;
        }
        Log.debug("Anzahl Nodes: " + counter);
        return counter;
    }

    public ListElement getFirstElementAndRemove(){
        ListElement newFirstElement = this.firstElement.getFollowingElement();
        ListElement oldElement = this.firstElement;
        Log.debug("RemovedElement: " + oldElement.getData());
        this.firstElement = newFirstElement;
        Log.debug("NewFirstElement: " + newFirstElement.getData());
        return oldElement;
    }

    public void removeElement(final ListElement removeElement){
        // First Element
        if(removeElement.equals(this.firstElement)){
            Log.debug("Erster Node soll gelöscht werden.");
            Log.info("Erster Node gelöscht: " + this.firstElement.getData());
            getFirstElementAndRemove();
        }

        ListElement lastElement = getLastElement();
        // End Element
        if(removeElement.equals(lastElement)) {
            Log.debug("Letzter Node soll gelöscht werden.");
            getPreviousElement(lastElement).setFollowingElementNull();
        }

        // Any Element
        if(searchElement(removeElement).equals(removeElement)){
            ListElement previousElement = getPreviousElement(removeElement);
            ListElement followingElement = removeElement.getFollowingElement();
            previousElement.setFollowingElement(followingElement);
        }
    }

}
