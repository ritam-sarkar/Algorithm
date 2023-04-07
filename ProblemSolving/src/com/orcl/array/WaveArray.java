package com.orcl.array;


import com.orcl.util.ArrayUtil;

/**
 * Input:
 * n = 5
 * arr[] = {1,2,3,4,5}
 * Output: 2 1 4 3 5
 * Explanation: Array elements after
 * sorting it in wave form are
 * 2 1 4 3 5.
 */
public class WaveArray {
    public static void main(String[] args) {
        int arr[] = {2,4,7,8,9,10};
        boolean desc = true;
        for (int i=0;i< arr.length-1;i++){
            if(desc){
                if(arr[i] < arr[i+1]){
                    ArrayUtil.swap(arr,i, i+1);
                }
            } else if(arr[i] > arr[i+1]){
                ArrayUtil.swap(arr,i, i+1);
            }
            desc = !desc;
        }
        ArrayUtil.traverse(arr);
    }
}
