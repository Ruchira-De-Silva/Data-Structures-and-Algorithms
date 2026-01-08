package data_structures.linked_list.singly;

public class LinkedLists {
    Node head;
    Node tail;

    // Uni-directional linked list
    public void insertAtStart(int value) {
        Node newNode = new Node();
        newNode.value = value;

        if (head != null) {
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
    }

    public void insert(int value) {
        Node newNode = new Node();
        newNode.value = value;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertAt(int value, Node next) {
        Node newNode = new Node();
        newNode.value = value;

        if (head == null || head == next) {
            insertAtStart(value);
        } else {
            Node current = head;

            while (current != null && current != next) {
                current = current.next;
            }

            if (current != null) {
                newNode.next = next;
                current.next = newNode;

                if (next == null) {
                    tail = newNode;
                }
            } else {
                throw new IllegalArgumentException("Provided next node not found in the list");
            }
        }
    }

    public void delete(Node deleting) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty no nodes to delete");
        }

        if (deleting == head) {
            head = head.next;

            if (head == null) {
                tail = null;
            }
        }

        Node current = head;
        while (current != null && current.next != deleting) {
            current = current.next;
        }

        if (current != null) {
            current.next = deleting.next;

            if (deleting == tail) {
                tail = current;
            }
        } else {
            throw new IllegalArgumentException("Provided next node not found in the list");
        }
    }

    public void show() {
        Node node = head;

        do {
            System.out.println(node.value);
            node = node.next;
        } while (node != null);
    }
}