package ch.hslu.ad.sw02.ChainedList;

import java.util.Objects;

public class ListElement {

    final String data;
    private ListElement followingElement;

    public ListElement(final String data) {
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

    public void setFollowingElementNull(){
        this.followingElement = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListElement element)) {
            return false;
        }

        return getData().equals(element.data);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.data, this.followingElement);
    }
}
