package data_structures.linked_list.doubly;

public class LinkedList {
    // Start of the linked list
    Node head;
    // End of the linked list
    Node tail;

    // Add a new node at the start with a value
    public void insertAtStart(int value) {
        Node newNode = new Node(value);

        if (head != null) { // If the list is not empty
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else { // If the list is empty
            head = newNode;
            tail = newNode;
        }
    }

    // Add a new node at the start
    public void insertAtStart(Node node) {
        if (head != null) { // If the list is not empty
            head.prev = node;
            node.next = head;
            head = node;
        } else { // If the list is empty
            head = node;
            tail = node;
        }
    }

    // Add a new node at the end with a value
    public void insert(int value) {
        Node newNode = new Node(value);

        if (head != null) { // If the list is not empty
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else { // If the list is empty
            insertAtStart(newNode);
        }
    }

    // Add a new node at the end
    public void insert(Node node) {
        if (head != null) { // If the list is not empty
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else { // If the list is empty
            insertAtStart(node);
        }
    }

    // Add a new node at a specific position
    public void insertAt(int value, int position) {
        if (position < 0) { // Invalid position
            throw new IllegalArgumentException("Position argument out of bound");
        }

        Node newNode = new Node(value);

        if (position == 0) { // Insert at the start
            insertAtStart(newNode);
            return;
        }

        if (head != null) { // If the list is not empty
            Node current = head;
            int index = 0;

            // Traverse to the position or the end
            while (current.next != null && index != position - 1) {
                current = current.next;
                index++;
            }

            // Handle tail or middle insertion
            // Why can this handle tail insertions?
            // If the loop terminates at the tail (current.next == null), we handle it here.
            if (index == position - 1) {
                if (current == tail) { // Insert at the tail
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                } else { // Insert in the middle
                    newNode.next = current.next;
                    current.next.prev = newNode;
                    current.next = newNode;
                    newNode.prev = current;
                }
            } else { // Position out of bounds
                throw new IllegalArgumentException("Specified node position not found in list");
            }
        } else { // If the list is empty
            throw new IllegalArgumentException("Cannot add to empty list");
        }
    }

    // Add a new node before a specific node
    public void insertAt(int value, Node nextNode) {
        if (nextNode == null) { // Invalid next node
            throw new NullPointerException("Position argument out of bound");
        }

        Node newNode = new Node(value);

        if (nextNode == head) { // Insert at the start
            insertAtStart(newNode);
            return;
        }

        if (head != null) { // If the list is not empty
            Node current = head;

            // Traverse to the node before the specified node
            while (current.next != null && current.next != nextNode) {
                current = current.next;
            }

            // Handle tail or middle insertion
            // Why can this handle tail insertions?
            // If the loop terminates at the tail (current.next == null), we handle it here.
            if (current.next == nextNode) {
                if (current == tail) { // Insert at the tail
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                } else { // Insert in the middle
                    newNode.next = current.next;
                    current.next.prev = newNode;
                    current.next = newNode;
                    newNode.prev = current;
                }
            } else { // Position out of bounds
                throw new IllegalArgumentException("Specified node position not found in list");
            }
        } else { // If the list is empty
            throw new IllegalArgumentException("Cannot add to empty list");
        }
    }

    // Display the linked list
    public void show() {
        Node current = head;

        while (current != null) { // Traverse the list
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
