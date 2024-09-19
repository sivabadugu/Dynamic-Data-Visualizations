import java.util.Stack;

public class SimpleStack {
    // Internal structure to hold the stack using Java's built-in Stack class
    private final Stack<Integer> stack = new Stack<>();

    // Method to push a value onto the stack
    void push(int value) {
        stack.push(value); // Add the value to the top of the stack
    }

    // Method to pop a value from the stack
    int pop() {
        return stack.pop(); // Remove and return the top value of the stack
    }

    // Method to peek at the top value without removing it
    int peek() {
        return stack.peek(); // Return the top value without modifying the stack
    }

    // Method to check if the stack is empty
    boolean isEmpty() {
        return stack.isEmpty(); // Returns true if there are no elements in the stack
    }

    // Main method for testing the SimpleStack functionality
    public static void main(String[] args) {
        SimpleStack myStack = new SimpleStack();

        // Check if the stack is empty
        if (myStack.isEmpty()) {
            System.out.println("The stack is empty.");
        }

        // Push some values onto the stack
        myStack.push(10);
        myStack.push(20);
        
        // Check again if the stack is empty
        if (!myStack.isEmpty()) {
            System.out.println("The stack is not empty.");
        }

        // Peek at the top value of the stack
        System.out.println("Top value: " + myStack.peek());

        // Pop a value from the stack and print it
        System.out.println("Popped value: " + myStack.pop());

        // Final check to see if the stack is empty
        if (myStack.isEmpty()) {
            System.out.println("The stack is now empty.");
        }
    }
}
