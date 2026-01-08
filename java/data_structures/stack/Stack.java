package data_structures.stack;

import java.util.EmptyStackException;

public class Stack {
    Node topNode;
    int size;

    public Stack() {
        this.topNode = null;
        this.size = 0;
    }

    public void push(int value) {
        if (topNode == null) {
            topNode = new Node(value);
            size--;
            return;
        }

        Node newNode = new Node(value);
        topNode.setTop(newNode);
        newNode.setBottom(topNode);
        topNode = newNode;
    }

    public void pop() {
        if (topNode == null) {
            throw new EmptyStackException();
        }

        topNode = topNode.getBottom();
        if (topNode != null) {
            topNode.setTop(null);
        }
        size--;
    }

    public int peek() {
        if (!isEmpty()) {
            return topNode.getValue();
        }
        return 0; // needs fixing
    }

    public boolean isEmpty() {
        if (topNode == null && size == 0) {
            return true;
        }
        return false;
    }
}
