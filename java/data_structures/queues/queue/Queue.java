package data_structures.queues.queue;

public class Queue {
    Node head;
    Node tail;
    int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
            size++;
        }

        Node newNode = new Node(value);

        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        size++;
    }

    public Node dequeue() {
        if (head == null) {
            // throw new EmptyQueue();
            return null;
        }

        Node ret = head;
        // Node newHead = head.getNext();

        if (head != null) {
            head.setPrev(null); // Disconnect the previous reference from the old head
        } else {
            tail = null; // If the queue becomes empty, set tail to null
        }

        ret.setNext(null); // Disconnect the old head node
        size--;
        return ret;
    }

    public Node peek() {
        return head;
    }

    public boolean isEmpty() {
        return head == null && size == 0;
    }
}
