public class Recursion {
    // Method to calculate the nth Fibonacci number using recursion
    int fibonacci(int n) {
        // Base case: return n if it's 0 or 1
        if (n <= 1) {
            return n;
        }
        // Recursive case: sum of the two preceding Fibonacci numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
