package ch.hslu.ad.sw02.ChainedList;

public class ListElement {

    String data;
    ListElement followingElement;

    public ListElement(String data) {
        this.followingElement = null;
        this.data = data;
    }
    public String getData() {
        return data;
    }

    public ListElement getFollowingElement() {
        return followingElement;
    }

    public void setFollowingElement(ListElement followingElement) {
        this.followingElement = followingElement;
    }
}
