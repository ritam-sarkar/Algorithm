package com.orcl.array;

import com.orcl.util.ArrayUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find kth smallest from an unsorted array
 */
public class KthMaxAndMinNumber {
    public static void main(String[] args) {
        int arr[] = {12, 29, 13, 31, 32, 22, 23};
        int k =3;
        // Find smallest
        System.out.println(k+" th smallest number ");
        System.out.println(findUsingHeap(arr,k, (a, b) -> b - a));
        System.out.println(quickSelect(arr,0, arr.length-1,k-1));
        // find largest
        System.out.println(k+" th max number");
        System.out.println(findUsingHeap(arr,k, (a, b) -> a - b));
        System.out.println(quickSelect(arr,0, arr.length-1,k+1));

    }

    private static int findUsingHeap(int[] arr, int k, Comparator<Integer> comparator) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(comparator);

        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        int partIndex = partition(arr, left, right);
        if (k == partIndex) {
            return arr[k];
        } else if (k < partIndex) {
            return quickSelect(arr, left, partIndex - 1, k);
        } else {
            return quickSelect(arr, partIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
       int pivot = arr[right];
       int pIndex = left;
       for (int i=left; i<=right;i++){
           if(arr[i] < pivot){
               ArrayUtil.swap(arr, pIndex, i);
               pIndex++;
           }
       }
       ArrayUtil.swap(arr, pIndex, right);
       return pIndex;
    }
}
