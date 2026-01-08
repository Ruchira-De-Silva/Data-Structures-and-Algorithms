package data_structures.stack;

public class Node {
    int value;
    Node top;
    Node bottom;

    public Node(int value) {
        this.value = value;
        this.top = null;
        this.bottom = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Node getBottom() {
        return bottom;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }
}
