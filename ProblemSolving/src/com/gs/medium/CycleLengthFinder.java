package com.gs.medium;

public class CycleLengthFinder {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 5, 3};  // Example with cycles

        System.out.println(findCycleLength(arr, 0));  // Output: 3 (0 -> 1 -> 2 -> 0)
        System.out.println(findCycleLength(arr, 3));  // Output: 3 (3 -> 4 -> 5 -> 3)
    }

    public static int findCycleLength(int[] arr, int start) {
        if (start < 0 || start >= arr.length) return 0;

        int slow = start, fast = start;

        // Step 1: Detect cycle using Floyd's algorithm
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Step 2: Find the cycle length
        int cycleLength = 1;
        int duplicate = arr[slow];
        while (duplicate != slow) {
            duplicate = arr[duplicate];
            cycleLength++;
        }

        return cycleLength;
    }
}
