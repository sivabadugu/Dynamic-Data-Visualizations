import java.util.PriorityQueue;

public class MinHeap {
    // Internal structure to hold the heap using a PriorityQueue
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Method to insert a value into the min heap
    void insert(int value) {
        minHeap.offer(value); // Use offer to add the value, maintaining heap properties
    }

    // Method to delete and return the minimum value from the heap
    int deleteMin() {
        return minHeap.poll(); // Poll removes and returns the minimum element
    }

    // Method to check if the heap is empty
    boolean isEmpty() {
        return minHeap.isEmpty(); // Returns true if the heap has no elements
    }

    // Method to get the minimum value without removing it
    int peek() {
        return minHeap.peek(); // Peek returns the minimum element without removal
    }

    // Main method for testing the MinHeap functionality
    public static void main(String[] args) {
        MinHeap myMinHeap = new MinHeap();

        // Insert some values into the min heap
        myMinHeap.insert(5);
        myMinHeap.insert(3);
        myMinHeap.insert(8);
        myMinHeap.insert(1);

        // Check if the heap is empty
        if (!myMinHeap.isEmpty()) {
            System.out.println("MinHeap is not empty.");
        }

        // Peek at the minimum value
        System.out.println("Minimum value: " + myMinHeap.peek());

        // Delete the minimum value and print it
        System.out.println("Deleted minimum value: " + myMinHeap.deleteMin());

        // Peek again to show the new minimum value
        System.out.println("New minimum value: " + myMinHeap.peek());

        // Delete all elements from the heap and print them
        while (!myMinHeap.isEmpty()) {
            System.out.println("Deleted value: " + myMinHeap.deleteMin());
        }

        // Final check to see if the heap is empty
        if (myMinHeap.isEmpty()) {
            System.out.println("MinHeap is now empty.");
        }
    }
}
