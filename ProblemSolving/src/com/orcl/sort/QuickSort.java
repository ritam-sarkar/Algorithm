package com.orcl.sort;

import com.orcl.util.ArrayUtil;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort left and right parts
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partitioning logic using Lomuto partition scheme
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int partIndex = low;

        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                ArrayUtil.swap(arr, partIndex, i);
                partIndex++;
            }
        }
        ArrayUtil.swap(arr, partIndex, high);
        return partIndex;
    }

    public static void main(String[] args) {
        int[] arr = {21, 23 , 18 , 12, 16 , 19 , 22, 27};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
