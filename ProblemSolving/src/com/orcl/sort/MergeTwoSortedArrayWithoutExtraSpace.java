package com.orcl.sort;

import com.orcl.util.ArrayUtil;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 *
 * Input: ar1[] = {10}, ar2[] = {2, 3}
 * Output: ar1[] = {2}, ar2[] = {3, 10}
 *
 * Input: ar1[] = {1, 5, 9, 10, 15, 20}, ar2[] = {2, 3, 8, 13}
 * Output: ar1[] = {1, 2, 3, 5, 8, 9}, ar2[] = {10, 13, 15, 20}
 */
public class MergeTwoSortedArrayWithoutExtraSpace {
    public static void main(String[] args) {

        int arr1[] = {3, 6, 10, 15};
        int arr2[] = {2, 5, 9, 11};
        merge(arr1, arr2);
        ArrayUtil.traverse(arr1);
        ArrayUtil.traverse(arr2);
    }

    private static void merge(int[] arr1, int[] arr2) {
        int i = 0;
        int temp = 0;
        int n = arr1.length;
        // While loop till last element
        // of array 1(sorted)
        // is greater than first element
        // of array 2(sorted)
        while (arr1[n - 1] > arr2[0]) {
            if (arr1[i] > arr2[0]) {

                // Swap arr1[i] with first element
                // of arr2 and sorting the updated
                // arr2(arr1 is already sorted)
                // swap(arr1[i],arr2[0]);
                temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                Arrays.sort(arr2);
            }
            i++;
        }
    }
}
