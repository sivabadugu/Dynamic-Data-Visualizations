class BST {
    private Node root; // Root node of the binary search tree

    // Node class to represent each element in the tree
    private class Node {
        int key; // Value of the node
        Node left, right; // Left and right children

        // Constructor to initialize a new node
        Node(int item) {
            key = item;
            left = right = null; // Initially, both children are null
        }
    }

    // Public method to insert a new key into the BST
    public void insert(int key) {
        root = insertRec(root, key); // Start the recursive insertion
    }

    // Recursive helper method to insert a new key
    private Node insertRec(Node root, int key) {
        // If the current node is null, create a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // Recursively find the correct position to insert the new key
        if (key < root.key) {
            root.left = insertRec(root.left, key); // Insert in the left subtree
        } else if (key > root.key) {
            root.right = insertRec(root.right, key); // Insert in the right subtree
        }
        return root; // Return the unchanged node pointer
    }

    // Public method to perform inorder traversal of the BST
    public void inorder() {
        inorderRec(root); // Start the recursive inorder traversal
    }

    // Recursive helper method for inorder traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left); // Visit left subtree
            System.out.print(root.key + " "); // Visit node
            inorderRec(root.right); // Visit right subtree
        }
    }

    // Public method to search for a key in the BST
    public boolean search(int key) {
        return searchRec(root, key); // Start the recursive search
    }

    // Recursive helper method to search for a key
    private boolean searchRec(Node root, int key) {
        // If the current node is null, key is not found
        if (root == null) return false;
        // If the key matches the current node's key, return true
        if (root.key == key) return true;
        // Recursively search in the left or right subtree
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Public method to find the maximum key in the BST
    public int findMax() {
        return findMaxRec(root); // Start the recursive search for maximum
    }

    // Recursive helper method to find the maximum key
    private int findMaxRec(Node root) {
        // If the tree is empty, throw an exception
        if (root == null) {
            throw new IllegalArgumentException("The tree is empty.");
        }
        // Traverse to the rightmost node to find the maximum
        while (root.right != null) {
            root = root.right;
        }
        return root.key; // Return the maximum value found
    }
}
