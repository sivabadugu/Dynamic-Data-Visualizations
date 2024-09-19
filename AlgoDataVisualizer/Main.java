import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Bubble Sort
        // Initialize an array to be sorted
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr); // Sort the array using Bubble Sort
        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Binary Search Tree
        // Create a Binary Search Tree (BST) and insert values
        BST bst = new BST();
        int[] bstValues = {5, 3, 7, 2, 4, 6, 8};
        for (int value : bstValues) {
            bst.insert(value); // Insert values into the BST
        }
        System.out.print("Inorder Traversal: ");
        bst.inorder(); // Print inorder traversal of the BST
        System.out.println();
        System.out.println("Searching for 4: " + bst.search(4)); // Search for a value in the BST
        System.out.println("Max value in BST: " + bst.findMax()); // Find the maximum value in the BST

        // Graph
        // Create a graph and add edges between vertices
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        System.out.print("DFS: ");
        List<Integer> dfsResult = graph.dfs(1); // Perform Depth-First Search (DFS)
        System.out.println(dfsResult);
        System.out.print("BFS: ");
        List<Integer> bfsResult = graph.bfs(1); // Perform Breadth-First Search (BFS)
        System.out.println(bfsResult);
        System.out.println("Graph connected: " + graph.isConnected()); // Check if the graph is connected

        // Min Heap
        // Create a Min Heap and insert values
        MinHeap minHeap = new MinHeap();
        int[] heapValues = {3, 1, 2, 0, 5};
        for (int value : heapValues) {
            minHeap.insert(value); // Insert values into the Min Heap
        }
        System.out.println("Min: " + minHeap.deleteMin()); // Delete and print the minimum value
        System.out.println("Heap after deletion: " + minHeap); // Print the heap after deletion

        // Stack
        // Create a simple stack and perform push and pop operations
        SimpleStack stack = new SimpleStack();
        int[] stackValues = {1, 2, 3, 4};
        for (int value : stackValues) {
            stack.push(value); // Push values onto the stack
        }
        System.out.println("Top element: " + stack.peek()); // Peek at the top element
        System.out.println("Popped element: " + stack.pop()); // Pop the top element
        System.out.println("Stack after pop: " + stack); // Print the stack after popping

        // Fibonacci
        // Create a Recursion object to calculate Fibonacci numbers
        Recursion recursion = new Recursion();
        System.out.println("Fibonacci of 5: " + recursion.fibonacci(5)); // Calculate Fibonacci(5)
        System.out.println("Fibonacci of 10: " + recursion.fibonacci(10)); // Calculate Fibonacci(10)
        System.out.println("Fibonacci of 20: " + recursion.fibonacciMemoized(20)); // Calculate Fibonacci(20) using memoization

        // Knapsack
        // Create a Knapsack object to solve the knapsack problem
        Knapsack knapsack = new Knapsack();
        int[] weights = {1, 2, 3}; // Weights of items
        int[] values = {60, 100, 120}; // Values of items
        int capacity = 5; // Capacity of the knapsack
        System.out.println("Max value in knapsack: " + knapsack.knapsack(capacity, weights, values)); // Calculate max value
    }
}

// Bubble Sort Implementation
class BubbleSort {
    // Method to sort an array using bubble sort
    public void bubbleSort(int[] arr) {
        int n = arr.length; // Get the length of the array
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Flag to check if a swap occurred
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // If no swaps occurred, the array is sorted
        }
    }

    // Helper method to swap elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Binary Search Tree Implementation
class BST {
    private Node root; // Root node of the BST

    private class Node {
        int key; // Key value of the node
        Node left, right; // Left and right children

        Node(int item) {
            key = item;
            left = right = null; // Initialize children as null
        }
    }

    // Method to insert a new key into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive method to insert a new key
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key); // Create a new node if the tree is empty
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key); // Insert in left subtree
        } else if (key > root.key) {
            root.right = insertRec(root.right, key); // Insert in right subtree
        }
        return root;
    }

    // Method for inorder traversal of the BST
    public void inorder() {
        inorderRec(root);
    }

    // Recursive method for inorder traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left); // Visit left subtree
            System.out.print(root.key + " "); // Visit node
            inorderRec(root.right); // Visit right subtree
        }
    }

    // Method to search for a key in the BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive method to search for a key
    private boolean searchRec(Node root, int key) {
        if (root == null) return false; // Base case
        if (root.key == key) return true; // Key found
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key); // Recur left or right
    }

    // Method to find the maximum value in the BST
    public int findMax() {
        return findMaxRec(root);
    }

    // Recursive method to find the maximum value
    private int findMaxRec(Node root) {
        if (root == null) throw new NoSuchElementException("Tree is empty"); // Check if tree is empty
        while (root.right != null) {
            root = root.right; // Traverse to the rightmost node
        }
        return root.key; // Return maximum value
    }
}

// Graph Implementation
class Graph {
    private final Map<Integer, List<Integer>> adjList; // Adjacency list representation of the graph

    public Graph() {
        adjList = new HashMap<>(); // Initialize the adjacency list
    }

    // Method to add an edge between two vertices
    public void addEdge(int v, int w) {
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(w); // Add w to v's list
        adjList.computeIfAbsent(w, k -> new ArrayList<>()).add(v); // Add v to w's list (undirected graph)
    }

    // Method for Depth-First Search (DFS)
    public List<Integer> dfs(int start) {
        Set<Integer> visited = new HashSet<>(); // Track visited vertices
        List<Integer> result = new ArrayList<>(); // Store DFS result
        dfsUtil(start, visited, result); // Perform DFS
        return result;
    }

    // Recursive utility method for DFS
    private void dfsUtil(int v, Set<Integer> visited, List<Integer> result) {
        visited.add(v); // Mark the vertex as visited
        result.add(v); // Add to result
        for (int neighbor : adjList.getOrDefault(v, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited, result); // Recur for unvisited neighbors
            }
        }
    }

    // Method for Breadth-First Search (BFS)
    public List<Integer> bfs(int start) {
        Set<Integer> visited = new HashSet<>(); // Track visited vertices
        List<Integer> result = new ArrayList<>(); // Store BFS result
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS
        visited.add(start); // Mark start as visited
        queue.add(start); // Add start to the queue
        while (!queue.isEmpty()) {
            int v = queue.poll(); // Remove the head of the queue
            result.add(v); // Add to result
            for (int neighbor : adjList.getOrDefault(v, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor); // Mark neighbor as visited
                    queue.add(neighbor); // Add neighbor to the queue
                }
            }
        }
        return result;
    }

    // Method to check if the graph is connected
    public boolean isConnected() {
        if (adjList.isEmpty()) return true; // An empty graph is considered connected
        Set<Integer> visited = new HashSet<>(); // Track visited vertices
        dfsUtil(adjList.keySet().iterator().next(), visited, new ArrayList<>()); // Start DFS from any vertex
        return visited.size() == adjList.size(); // Check if all vertices were visited
    }
}

// Min Heap Implementation
class MinHeap {
    private final List<Integer> heap; // List to store heap elements

    public MinHeap() {
        heap = new ArrayList<>(); // Initialize the heap
    }

    // Method to insert a value into the Min Heap
    public void insert(int value) {
        heap.add(value); // Add value to the end of the list
        bubbleUp(heap.size() - 1); // Restore heap property
    }

    // Helper method to restore heap property by bubbling up
    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2; // Calculate parent index
            if (heap.get(index) >= heap.get(parentIndex)) break; // If heap property is satisfied, exit
            Collections.swap(heap, index, parentIndex); // Swap with parent
            index = parentIndex; // Move up to parent
        }
    }

    // Method to delete and return the minimum value from the Min Heap
    public int deleteMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty"); // Check if heap is empty
        int minValue = heap.get(0); // Store minimum value
        int lastIndex = heap.size() - 1; // Index of the last element
        heap.set(0, heap.get(lastIndex)); // Move last element to root
        heap.remove(lastIndex); // Remove last element
        bubbleDown(0); // Restore heap property
        return minValue; // Return the minimum value
    }

    // Helper method to restore heap property by bubbling down
    private void bubbleDown(int index) {
        while (index < heap.size()) {
            int leftChildIndex = 2 * index + 1; // Left child index
            int rightChildIndex = 2 * index + 2; // Right child index
            int smallest = index; // Assume current index is the smallest
            // Check if left child is smaller than the current smallest
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallest)) {
                smallest = leftChildIndex; // Update smallest index
            }
            // Check if right child is smaller than the current smallest
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallest)) {
                smallest = rightChildIndex; // Update smallest index
            }
            if (smallest == index) break; // If no swaps needed, exit
            Collections.swap(heap, index, smallest); // Swap with the smallest child
            index = smallest; // Move down to the smallest child
        }
    }

    @Override
    public String toString() {
        return heap.toString(); // Return string representation of the heap
    }
}

// Simple Stack Implementation
class SimpleStack {
    private final LinkedList<Integer> stack; // LinkedList to implement the stack

    public SimpleStack() {
        stack = new LinkedList<>(); // Initialize the stack
    }

    // Method to push a value onto the stack
    public void push(int value) {
        stack.addFirst(value); // Add value to the top of the stack
    }

    // Method to pop the top value off the stack
    public int pop() {
        if (stack.isEmpty()) throw new EmptyStackException(); // Check if stack is empty
        return stack.removeFirst(); // Remove and return the top value
    }

    // Method to peek at the top value of the stack without removing it
    public int peek() {
        if (stack.isEmpty()) throw new EmptyStackException(); // Check if stack is empty
        return stack.getFirst(); // Return the top value
    }

    @Override
    public String toString() {
        return stack.toString(); // Return string representation of the stack
    }
}

// Recursion for Fibonacci
class Recursion {
    private final Map<Integer, Integer> memo = new HashMap<>(); // Memoization map for Fibonacci

    // Method to calculate Fibonacci number recursively
    public int fibonacci(int n) {
        if (n <= 1) return n; // Base case
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive calculation
    }

    // Method to calculate Fibonacci number using memoization
    public int fibonacciMemoized(int n) {
        if (n <= 1) return n; // Base case
        if (memo.containsKey(n)) return memo.get(n); // Return memoized result if available
        int result = fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2); // Recursive calculation
        memo.put(n, result); // Store result in memoization map
        return result; // Return the result
    }
}

// Knapsack Problem Implementation
class Knapsack {
    // Method to solve the knapsack problem
    public int knapsack(int capacity, int[] weights, int[] values) {
        return knapsackRec(capacity, weights, values, weights.length); // Start recursive knapsack calculation
    }

    // Recursive method to solve the knapsack problem
    private int knapsackRec(int capacity, int[] weights, int[] values, int n) {
        if (n == 0 || capacity == 0) return 0; // Base case
        if (weights[n - 1] > capacity) return knapsackRec(capacity, weights, values, n - 1); // Exclude current item
        // Include current item and calculate value
        int include = values[n - 1] + knapsackRec(capacity - weights[n - 1], weights, values, n - 1);
        // Exclude current item and calculate value
        int exclude = knapsackRec(capacity, weights, values, n - 1);
        return Math.max(include, exclude); // Return maximum value of both choices
    }
}
