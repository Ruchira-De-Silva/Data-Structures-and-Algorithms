package data_structures.trees.AVL;

public class TreeNode {
    private int value;
    private TreeNode leftChild;
    private TreeNode rightChild;
    private TreeNode parent;
    private int height;

    public TreeNode(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
        this.height = 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
