package data_structures.queues.priorityQueue;

public class Node {
    private int key;
    private int value;
    private Node next;
    private Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

}
