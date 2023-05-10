package com.orcl.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of N integers, and an integer K, find the number of pairs of
 * elements in the array whose sum is equal to K
 *
 * https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
 *
 */
public class CountPairsInGivenSum {

    public static void main(String[] args) {

        int arr1[] = {1, 5, 7, 1};
        int k = 6;
        System.out.println(getPairsCount(arr1,arr1.length,k));

        int arr2[] = {1, 1, 1, 1};
        k = 2;
        System.out.println(getPairsCount(arr2,arr2.length,k));

        int arr3[] = {1, 5, 5, 5, 5, 7};
        k = 10;
        System.out.println(getPairsCount(arr3,arr3.length,k));


    }

    private static int getPairsCount(int[] arr, int n, int k) {
        Map<Integer,Integer> complementMap = new HashMap<>();
        int count = 0;
        for(int i=0;i<n;i++){
            if(complementMap.containsKey(arr[i])){
                count = count + complementMap.get(arr[i]);
                complementMap.put(k-arr[i],complementMap.getOrDefault(k-arr[i],0)+1);
            } else if(arr[i] < k){
                complementMap.put(k-arr[i],complementMap.getOrDefault(k-arr[i],0)+1);
            }
        }
        return count;
    }
}
