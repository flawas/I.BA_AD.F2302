package ch.hslu.ad.sw02.ChainedList;

public class ListElement {

    String data;
    ListElement followingElement;

    public ListElement() {
        this.followingElement = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ListElement getFollowingElement() {
        return followingElement;
    }

    public void setFollowingElement(ListElement followingElement) {
        this.followingElement = followingElement;
    }
}
