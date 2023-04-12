package com.orcl.array;

import com.orcl.util.ArrayUtil;

/**
 * Given an array A[] consisting of only 0s, 1s, and 2s. The task is to write
 * a function that sorts the given array. The functions should put all 0s first,
 * then all 1s and all 2s in last
 *
 * Given N balls of colour red, white or blue arranged in a line in random order.
 * You have to arrange all the balls such that the balls with the same colours are adjacent with the order
 * of the balls, with the order of the colours being red, white and blue
 * (i.e., all red coloured balls come first then the white coloured balls and then the blue coloured balls).
 */
public class DuthFlagProblem {
    public static void main(String[] args) {
        int[] arr1 = {0,2,1,1,0,1,2,1,0,2,2,0};
        int[] arr2 = {0,2,1,2,0};

        sort012(arr1, arr1.length);
        ArrayUtil.traverse(arr1);
    }

    private static void sort012(int[] arr, int n) {

        /**
         * mid is an indicator index
         * mid = 1 means okay we can move on
         * mid = 0 means we need to swap with low as low should contain 0, then mid++ , low ++
         * mid = 2 means we need to swap with high as high should contain 2, then high--, but we do not
         * update mid position , as after swapping mid position can hold 0 or 1 anything, so need one more iteration
         */
        int low = 0;
        int high = n-1;
        int mid = 0;

        while (mid <= high){
            switch (arr[mid]){

                case 0:
                    ArrayUtil.swap(arr,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    ArrayUtil.swap(arr,high,mid);
                    high--;
            }
        }
    }

}
