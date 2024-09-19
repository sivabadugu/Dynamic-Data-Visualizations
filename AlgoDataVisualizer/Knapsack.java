public class Knapsack {
    // Method to solve the 0/1 Knapsack problem using dynamic programming
    public int knapsack(int capacity, int[] weights, int[] values) {
        int n = values.length; // Number of items
        // Create a 2D array to store the maximum value at each n and capacity combination
        int[][] dp = new int[n + 1][capacity + 1];

        // Iterate through each item
        for (int i = 1; i <= n; i++) {
            // Iterate through each weight capacity from 1 to the given capacity
            for (int w = 1; w <= capacity; w++) {
                // Check if the weight of the current item is less than or equal to the capacity
                if (weights[i - 1] <= w) {
                    // Maximize value: either take the item or leave it
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // If the item cannot be included, take the value from the previous item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        // The maximum value that can be obtained with the given capacity
        return dp[n][capacity];
    }
}
