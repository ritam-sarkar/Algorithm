package com.orcl.array;

/**
 * Given an array Arr[] that contains N integers (may be positive, negative or zero).
 * Find the product of the maximum product subarray.
 * Example 1:
 * Input:
 * N = 5
 * Arr[] = {6, -3, -10, 0, 2}
 * Output: 180
 * Explanation: Subarray with maximum product
 * is [6, -3, -10] which gives product as 180.
 * Example 2:
 * <p>
 * Input:
 * N = 6
 * Arr[] = {2, 3, 4, 5, -1, 0}
 * Output: 120
 * Explanation: Subarray with maximum product
 * is [2, 3, 4, 5] which gives product as 120.
 *
 * Input : -8, 5, 3, 1, 6
 * Output : 90
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int arr1[] = {-8, 5, 3, 1, 6};
        int arr2[] = {2, 3, 4, 5, -1, 0};
        System.out.println(maxProduct(arr1, arr1.length));
    }

    private static long maxProduct(int[] arr, int n) {
        long currentMax = 1;
        long max = Integer.MIN_VALUE;
        // forward parse
        for (int i = 0; i < n; i++) {
            currentMax *= arr[i];
            max = Math.max(currentMax, max);
            if (arr[i] == 0) {
                currentMax = 1;
            }
        }
        // backward parse
        currentMax = 1;
        for (int i = n - 1; i >= 0; i--) {
            currentMax *= arr[i];
            max = Math.max(currentMax, max);
            if (arr[i] == 0) {
                currentMax = 1;
            }
        }
        return max;
    }
}

