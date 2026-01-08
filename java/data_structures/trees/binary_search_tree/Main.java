package data_structures.trees.binary_search_tree;

public class Main {
    public static void main(String[] args) {
        testEmptyTree();
        testSingleNode();
        testMultipleNodes();
        testEdgeCases();
        testDeletion();
        
        System.out.println("\nAll tests completed!");
    }

    private static void testEmptyTree() {
        printTestHeader("Testing Empty Tree");
        BinarySearchTree bst = new BinarySearchTree();
        
        assertNull("Finding parent in empty tree", bst.getParent(10));
        assertNull("Root should be null", bst.root);
        
        // Insert into empty tree
        bst.insert(50);
        assertEquals("Root value after insertion", 50, bst.root.value);
        assertEquals("Depth of root node", 0, bst.depth(50));
    }

    private static void testSingleNode() {
        printTestHeader("Testing Single Node Tree");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);

        // Test finding nodes
        assertEquals("Depth of root", 0, bst.depth(50));
        assertEquals("Depth of non-existent node", -1, bst.depth(30));

        // Test getting parent
        assertNull("Parent of root", bst.getParent(50));
        
        // Test node-based operations
        TreeNode node = new TreeNode(50);
        assertEquals("Depth using node object", 0, bst.depth(node));
    }

    private static void testMultipleNodes() {
        printTestHeader("Testing Multiple Nodes Tree");
        BinarySearchTree bst = new BinarySearchTree();

        // Create a balanced tree:
        //       50
        //     /    \
        //   30      70
        //  /  \    /  \
        // 20   40 60   80

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }

        // Test depths
        assertEquals("Root (50) depth", 0, bst.depth(50));
        assertEquals("Level 1 (30) depth", 1, bst.depth(30));
        assertEquals("Level 2 (40) depth", 2, bst.depth(40));

        // Test parent relationships
        assertEquals("Parent of 40", 30, bst.getParent(40).value);
        assertEquals("Parent of 30", 50, bst.getParent(30).value);
        assertNull("Parent of root", bst.getParent(50));

        // Verify tree structure
        assertEquals("Root value", 50, bst.root.value);
        assertEquals("Left child of root", 30, bst.root.leftChild.value);
        assertEquals("Right child of root", 70, bst.root.rightChild.value);
    }

    private static void testEdgeCases() {
        printTestHeader("Testing Edge Cases");
        BinarySearchTree bst = new BinarySearchTree();
        
        // Test with null node
        try {
            bst.insert((TreeNode)null);
            System.out.println("FAILED: Should throw exception for null node");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED: Correctly threw exception for null node");
        }

        // Test inserting duplicate values
        bst.insert(50);
        bst.insert(50); // Should handle this gracefully
        assertNull("Right child after duplicate insert", bst.root.rightChild);
        assertNull("Left child after duplicate insert", bst.root.leftChild);

        // Test non-existent values
        assertEquals("Finding non-existent value", -1, bst.depth(100));
        assertNull("Parent of non-existent value", bst.getParent(100));
    }

    private static void testDeletion() {
        printTestHeader("Testing Deletion");
        BinarySearchTree bst = new BinarySearchTree();
        
        // Setup tree
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }

        // Test deleting leaf node
        bst.deletion(20, true);
        assertNull("Deleted leaf node", bst.root.leftChild.leftChild);

        // Test deleting node with one child
        bst.deletion(70, true);
        assertEquals("Node replaced by child", 80, bst.root.rightChild.value);

        // Test deleting node with two children
        bst.deletion(30, true);
        assertNotEquals("Node 30 should be replaced", 30, bst.root.leftChild.value);

        // Test deleting root
        bst.deletion(50, true);
        assertNotEquals("Root should be replaced", 50, bst.root.value);

        try {
            bst.deletion(999, true);
            System.out.println("FAILED: Should throw exception for non-existent node");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED: Correctly threw exception for non-existent node");
        }
    }

    // Generic test utility methods
    private static void printTestHeader(String testName) {
        System.out.println("\n=== " + testName + " ===");
    }

    private static void assertEquals(String message, int expected, int actual) {
        if (expected == actual) {
            System.out.println("PASSED: " + message);
        } else {
            System.out.println("FAILED: " + message + " (Expected: " + expected + ", Got: " + actual + ")");
        }
    }

    private static void assertNull(String message, Object obj) {
        if (obj == null) {
            System.out.println("PASSED: " + message);
        } else {
            System.out.println("FAILED: " + message + " (Expected: null, Got: " + obj + ")");
        }
    }

    private static void assertNotEquals(String message, int unexpected, int actual) {
        if (unexpected != actual) {
            System.out.println("PASSED: " + message);
        } else {
            System.out.println("FAILED: " + message + " (Got unexpected value: " + actual + ")");
        }
    }
}
