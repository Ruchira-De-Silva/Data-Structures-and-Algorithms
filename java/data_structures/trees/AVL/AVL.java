package data_structures.trees.AVL;

import data_structures.trees.AVL.AVLExceptions.DuplicateValueException;
import data_structures.trees.AVL.AVLExceptions.NullNodeException;

public class AVL {
    private TreeNode root;

    public AVL() {
        root = null;
    }

    private int height(TreeNode node) {
        return (node != null) ? node.getHeight() : 0;

    }

    private int balancedFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private void updateHeight(TreeNode node) {
        if (node != null) {
            node.setHeight(1 + Math.max(height(node.getLeftChild()), height(node.getRightChild())));
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode node, int value) {
        // if the traversal reaches the end of the tree
        if (node == null) {
            return new TreeNode(value);
        }

        // if the value is smaller than the node
        if (node.getValue() > value) {
            // get the left child after balancing
            TreeNode leftChild = insert(node.getLeftChild(), value);
            // update the left child to the left node of a balanced tree
            node.setLeftChild(leftChild);
            // update the parent field
            leftChild.setParent(node);
        } else if (node.getValue() < value) {
            TreeNode rightChild = insert(node.getRightChild(), value);
            node.setRightChild(rightChild);
            rightChild.setParent(node);
        } else {
            throw new DuplicateValueException(value);
        }

        // update the height of the target node
        updateHeight(node);
        // return the root node after balancing the sub-tree
        return balance(node);
    }

    public void largestDelete(int value) {
        root = largestDelete(root, value);
    }

    private TreeNode largestDelete(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (node.getValue() == value) {
            // leaf node
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                return null;
                // node with right child
            } else if (node.getLeftChild() == null) {
                TreeNode rightChild = node.getRightChild();
                rightChild.setParent(node.getParent());
                return rightChild;
                // node with left child
            } else if (node.getRightChild() == null) {
                TreeNode leftChild = node.getLeftChild();
                leftChild.setParent(node.getParent());
                return leftChild;
            } else {
                TreeNode largestLeft = largestNode(node.getLeftChild());

                node.setValue((largestLeft.getValue()));
                node.setLeftChild(largestDelete(node.getLeftChild(), largestLeft.getValue()));
            }

        } else if (node.getValue() > value) {
            TreeNode leftChild = largestDelete(node.getLeftChild(), value);
            // update the parent fields
            node.setLeftChild(leftChild);
            if (leftChild != null) {
                leftChild.setParent(node);
            }
        } else {
            TreeNode rightChild = largestDelete(node.getRightChild(), value);

            // update the parent fields
            node.setRightChild(rightChild);
            if (rightChild != null) {
                rightChild.setParent(node);
            }
        }

        updateHeight(node);
        return balance(node);
    }

    private TreeNode largestNode(TreeNode node) {
        TreeNode current = node;

        while (current != null && current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }

    private TreeNode lowestNode(TreeNode node) {
        TreeNode current = node;
        TreeNode parent = null;

        while (current != null) {
            parent = current;
            current = current.getLeftChild();
        }

        return parent;
    }

    private TreeNode balance(TreeNode node) {
        if (node == null) {
            throw new NullNodeException();
        }

        int balance = balancedFactor(node);

        // left heavy
        if (balance > 1) {
            if (balancedFactor(node.getLeftChild()) < 0) {
                node.setLeftChild(leftRotation(node.getLeftChild()));
            }
            return rightRotation(node);
            // right heavy
        } else if (balance < -1) {
            if (balancedFactor(node.getRightChild()) > 0) {
                node.setRightChild(rightRotation(node.getRightChild()));
            }
            return leftRotation(node);
        }
        return node;
    }

    private TreeNode leftRotation(TreeNode node) {
        TreeNode rightChild = node.getRightChild();
        TreeNode lowLeft = rightChild.getLeftChild();

        // updating sub-tree root
        rightChild.setLeftChild(node);
        node.setRightChild(lowLeft);

        // updating parents
        rightChild.setParent(node.getParent());
        node.setParent(rightChild);
        if (lowLeft != null) {
            lowLeft.setParent(node);
        }

        // update height
        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    private TreeNode rightRotation(TreeNode node) {
        TreeNode leftChild = node.getLeftChild();
        TreeNode lowRight = leftChild.getRightChild();

        // updating sub-tree root
        leftChild.setRightChild(node);
        node.setLeftChild(lowRight);

        // updating parents
        leftChild.setParent(node.getParent());
        node.setParent(leftChild);
        if (lowRight != null) {
            lowRight.setParent(node);
        }

        // update height
        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }
}
