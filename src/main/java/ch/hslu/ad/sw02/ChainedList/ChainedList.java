package ch.hslu.ad.sw02.ChainedList;

import java.util.List;

public class ChainedList {

    ListElement head;
    ListElement tail;
    private int listSize;

    public ChainedList() {
        this.listSize = 0;
        this.head = new ListElement();
        this.tail = new ListElement();
    }

    public void newListElement(final ListElement newListElement){
        this.listSize++;
        this.getLastElement().setFollowingElement(newListElement);
    }

    public ListElement getLastElement(){
        if(this.getListSize() == 0){
            return this.head;
        } else {
            return this.head;
        }
    }


    public int getListSize() {
        return this.listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public void setListSizePlusOne(){
        this.listSize = this.listSize + 1;
    }
}
