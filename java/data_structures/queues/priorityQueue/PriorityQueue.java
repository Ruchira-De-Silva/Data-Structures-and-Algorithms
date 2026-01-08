package data_structures.queues.priorityQueue;

public class PriorityQueue {
    private Node head;
    private Node tail;
    private int size;

    public PriorityQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void enqueue(int key, int value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            tail = node;
            size++;
        } else {
            if (head.getValue() < value) {
                head.setPrev(node);
                node.setNext(head);
                head = node;
                size++;
            } else {
                Node current = head;

                while (current.getNext() != null && current.getValue() > value) {
                    current = current.getNext();
                }

                if (current == tail) {
                    tail.setNext(node);
                    node.setPrev(tail);
                    tail = node;
                    size++;
                } else {
                    Node next = current.getNext();
                    current.setNext(node);
                    next.setPrev(node);

                    node.setNext(next);
                    node.setPrev(current);
                    size++;
                }
            }
        }
    }

    public Node dequeue(int key) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        if (head.getKey() == key) {
            Node oldHead = head;
            oldHead.getNext().setPrev(null);
            head = oldHead.getNext();
            oldHead.setNext(null);
            return oldHead;
        } else if (tail.getKey() == key) {
            Node oldTail = tail;
            oldTail.getPrev().setNext(null);
            tail = oldTail.getPrev();
            oldTail.setPrev(null);
            return oldTail;
        }

        Node current = head;

        while (current.getNext() == null && current.getKey() != key) {
            current = current.getNext();
        }

        if (current.getKey() != key) {
            throw new IllegalArgumentException("No valid key found");
        } else {
            Node prev = current.getPrev();
            Node next = current.getNext();

            prev.setNext(next);
            next.setPrev(prev);

            current.setNext(null);
            current.setPrev(null);
            size--;
        }
        return current;
    }
}
