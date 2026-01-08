package data_structures.trees.binary_search_tree;

public class BinarySearchTree {
    TreeNode root;

    // left child is lower than their parent
    // right child is greater than their parent

    // getting the parent node using a value
    public TreeNode getParent(int value) {
        TreeNode current = root;
        TreeNode parent = null;

        /*
         * looping until the there is no node or the value of the current node is not
         * the target
         */
        while (current != null && current.value != value) {
            parent = current;
            // traversal
            current = (current.value > value) ? current.leftChild : current.rightChild;
        }
        return (current != null) ? parent : null;
    }

    // getting the parent node using a value
    public TreeNode getParent(TreeNode node) {
        TreeNode current = root;
        TreeNode parent = null;

        /*
         * looping until the there is no node or the value of the current node is not
         * the target
         */
        while (current != null && current.value != node.value) {
            parent = current;
            // traversal
            current = (current.value > node.value) ? current.leftChild : current.rightChild;
        }
        return (current != null) ? parent : null;
    }

    // searches for if a matching node value is in the tree
    private TreeNode findNode(int value) {
        TreeNode current = root;

        /*
         * looping until the there is no node or the value of the current node is not
         * the target
         */
        while (current != null && current.value != value) {
            // traversal
            current = (current.value > value) ? current.leftChild : current.rightChild;
        }

        return current;
    }

    // searches for if a matching node value is in the tree
    private TreeNode findNode(TreeNode node) {
        TreeNode current = root;

        /*
         * looping until the there is no node or the value of the current node is not
         * the target
         */
        while (current != null && current.value != node.value) {
            // traversal
            current = (current.value > node.value) ? current.leftChild : current.rightChild;
        }

        return current;
    }

    // method to get the largest value of any sub-tree
    private TreeNode findLargestNode(TreeNode node) {
        if (node == null)
            return null;
        // loop until the right child is null
        while (node.rightChild != null) {
            node = node.rightChild;
        }
        return node;
    }

    // method ti get the smallest value of any sub-tree
    private TreeNode findSmallestNode(TreeNode node) {
        if (node == null)
            return null;
        // loop until the left child is null
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    // method to depth of the node in the tree
    public int depth(TreeNode node) {
        // checking if the target is null
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null.");
        }

        TreeNode current = root;
        int depth = 0;

        /*
         * looping until the there is no node or the value of the current node is not
         * the target
         */
        while (current != null) {
            if (node.value == current.value) {
                return depth;
            }
            // traversal
            current = (current.value > node.value) ? current.leftChild : current.rightChild;
            depth++;
        }
        return -1;
    }

    // method to depth of the node in the tree
    public int depth(int value) {
        TreeNode current = root;
        int depth = 0;

        /*
         * looping until the there is no node or the value of the current node is not
         * the target
         */
        while (current != null) {
            if (value == current.value) {
                return depth;
            }
            // traversal
            current = (current.value > value) ? current.leftChild : current.rightChild;
            depth++;
        }
        return -1;
    }

    // method to insert new values to tree
    public void insert(int value) {
        TreeNode node = new TreeNode(value);

        // checking if there is a root
        if (root == null) {
            root = node;
            return;
        }

        TreeNode current = root;

        while (current != null) {
            if (current.value > value) {
                if (current.leftChild != null) {
                    current = current.leftChild;
                } else {
                    current.leftChild = node;
                    return;
                }
            } else if (current.value < value) {
                if (current.rightChild != null) {
                    current = current.rightChild;
                } else {
                    current.rightChild = node;
                    return;
                }
            } else {
                return;
            }
        }
    }

    // method to insert new node
    public void insert(TreeNode node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }

        // checking if the there is a tree
        if (root == null) {
            root = node;
            return;
        }

        TreeNode current = root;

        while (current != null) {

            if (current.value > node.value) {
                if (current.leftChild != null) {
                    current = current.leftChild;
                } else {
                    current.leftChild = node;
                    return;
                }
            } else if (current.value < node.value) {
                if (current.rightChild != null) {
                    current = current.rightChild;
                } else {
                    current.rightChild = node;
                    return;
                }
            } else {
                return;
            }
        }
    }

    // removing nodes in all cases
    /*
     * removing nodes with 2 children by swapping with the largest value in the
     * left sub-tree relative to the target
     */
    public void deletion(int value, boolean left) {
        // finding the target node
        TreeNode target = findNode(value);

        // if the target is not found
        if (target == null) {
            throw new IllegalArgumentException("Node not in tree");
        }

        // getting the parent node of the target node
        TreeNode targetParent = getParent(value);

        // if the target node is a leaf node
        if (target.leftChild == null && target.rightChild == null) {
            // if the target is the root
            if (targetParent == null) {
                root = null;
                // if the target is the left child
            } else if (targetParent.value > value) {
                targetParent.leftChild = null;
                // if the target is the right child
            } else {
                targetParent.rightChild = null;
            }
            // if the target has one child
        } else if (target.leftChild == null || target.rightChild == null) {
            // getting the child of the target node
            TreeNode child = (target.leftChild != null) ? target.leftChild : target.rightChild;

            // if the target is the root node
            if (targetParent == null) {
                root = child;
                // if the target is left child
            } else if (targetParent.leftChild == target) {
                targetParent.leftChild = child;
                // if the target is the right child
            } else {
                targetParent.rightChild = child;
            }
            // if the target has 2 children
        } else {
            if (left) {
                // getting the largest node of the left sub-tree
                TreeNode largestNode = findLargestNode(target.leftChild);
                // removing the largest value
                deletion(largestNode.value, true);
                // updating the target to the largest value
                target.value = largestNode.value;
            } else {
                // getting the smallest node of the right sub-tree
                TreeNode smallestNode = findSmallestNode(target.rightChild);
                // removing the smallest value
                deletion(smallestNode.value, false);
                // updating the target to the smallest value
                target.value = smallestNode.value;
            }
        }
    }
}
