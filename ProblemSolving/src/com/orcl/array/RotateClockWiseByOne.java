package com.orcl.array;

import com.orcl.util.ArrayUtil;

/**
 * https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * A[] = {1, 2, 3, 4, 5}
 * Output:
 * 5 1 2 3 4
 *
 *
 * Example 2:
 *
 * Input:
 * N = 8
 * A[] = {9, 8, 7, 6, 4, 2, 1, 3}
 * Output:
 * 3 9 8 7 6 4 2 1
 *
 */
public class RotateClockWiseByOne {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 2, 4, 5, 1};
        rotate(arr1, arr1.length);
        ArrayUtil.traverse(arr1);
        rotate(arr2, arr2.length);
        ArrayUtil.traverse(arr2);
    }

    private static void rotate(int arr[], int n) {
        for (int i = n - 1; i > 0; i--) {
            ArrayUtil.swap(arr, i, i - 1);
        }
    }
}
