package ch.hslu.ad.sw02.ChainedList;

public class ListElement {

    ListElement followingElement;
    private boolean hasNextElement;

    public ListElement() {
        this.followingElement = null;
        this.hasNextElement = false;
    }

    public void setFollowingElement(ListElement followingElement){
        this.followingElement = followingElement;
    }

    public ListElement getFollowingElement(){
        return this.followingElement;
    }
}
