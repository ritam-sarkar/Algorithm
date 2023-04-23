package com.orcl.array;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
 *
 * Example 1:
 *
 * Input:
 * K = 2, N = 4
 * Arr[] = {1, 5, 8, 10}
 * Output:
 * 5
 * Explanation:
 * The array can be modified as
 * {3, 3, 6, 8}. The difference between
 * the largest and the smallest is 8-3 = 5.
 * Example 2:
 *
 * Input:
 * K = 3, N = 5
 * Arr[] = {3, 9, 12, 16, 20}
 * Output:
 * 11
 * Explanation:
 * The array can be modified as
 * {6, 12, 9, 13, 17}. The difference between
 * the largest and the smallest is 17-6 = 11.
 *
 * https://www.youtube.com/watch?v=tSLiZAQG9NM
 */
public class MinimizeHeightsOfTower {
    public static void main(String[] args) {

        int arr1[] = {1,5,8,10};
        int arr2[] = {3,9,12,16,20};
        int arr3[] = {2,4,81};
        //System.out.println(getMinDiff(arr1,arr1.length,2));
        //System.out.println(getMinDiff(arr2,arr2.length,3));
        System.out.println(getMinDiff(arr3,arr3.length,5));
    }
    static int getMinDiff(int[] arr, int n, int k){
        // a c d b >> a min b max c and d  we need to maximaize and minimize
        if (arr == null || n<=0) return -1;
        Arrays.sort(arr);
        int min = 0,max = 0,res = 0;
        res = arr[n-1] - arr[0];
        // i = d position
        for (int i = 1;i<n;++i){
            if (arr[i]>=k){
                // maximize c+k
                max = Math.max(arr[i-1]+k,arr[n-1]-k);
                // minimize d -k
                min   =Math.min(arr[i]-k,arr[0]+k);
                res = Math.min(res,max-min);
            }
        }
        return res;
    }
}
