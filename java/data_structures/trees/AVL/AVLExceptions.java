package data_structures.trees.AVL;

public class AVLExceptions {

    public static class AVLTreeException extends RuntimeException {
        public AVLTreeException(String message) {
            super(message);
        }
    }

    public static class DuplicateValueException extends AVLTreeException {
        public DuplicateValueException(int value) {
            super("Duplicate value: " + value);
        }
    }

    public static class NoParentNodeException extends AVLTreeException {
        public NoParentNodeException() {
            super("Parent node is null.");
        }
    }

    public static class NoChildNodeException extends AVLTreeException {
        public NoChildNodeException() {
            super("Child nodes are null.");
        }
    }

    public static class NullNodeException extends AVLTreeException {
        public NullNodeException() {
            super("Node is null");
        }
    }
}
