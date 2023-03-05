package ch.hslu.ad.sw02.ArrayStack;

public class ArrayStackElement {

    private String data;


    public ArrayStackElement(final String data) {
        this.data = data;
    }

    /* --------------------------------------------------------------------------------
     * Getter-Methoden
     * --------------------------------------------------------------------------------
     */

    public String getData() {
        return data;
    }

    /* --------------------------------------------------------------------------------
     * Setter-Methoden
     * --------------------------------------------------------------------------------
     */

    public void setData(String data) {
        this.data = data;
    }


    /* --------------------------------------------------------------------------------
     * Hilfsmethoden
     * --------------------------------------------------------------------------------
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayStackElement)) return false;

        ArrayStackElement that = (ArrayStackElement) o;

        if (getData() != null ? !getData().equals(that.getData()) : that.getData() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getData() != null ? getData().hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "ArrayStackElement{" +
                "data='" + data + '\'' +
                '}';
    }
}
