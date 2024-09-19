public class BubbleSort {
    // Method to sort an array using the Bubble Sort algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length; // Get the length of the array
        
        // Outer loop to traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is greater than the next element, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; // Store current element in a temporary variable
                    arr[j] = arr[j + 1]; // Swap the elements
                    arr[j + 1] = temp; // Assign the temporary variable to the next element
                }
            }
            // Optional: Print the array after each outer loop iteration for debugging
            // System.out.println("Array after iteration " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }
}
