package com.orcl.slidingWindow;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 *
 * xample 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores)
 */
public class RemovceDuplicatesFromArrayWithOutExtraSpace {
    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[] {1,1,2}));
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[] {0,0,1,1,3,3,4}));
        System.out.println(removeDuplicates(new int[] {0,1,3,3,3,4,5,5}));
    }

    private static int removeDuplicates(int[] arr){
        int k =0;
        for (int i=1; i<arr.length;i++){
            if(arr[k]!=arr[i]){
                k++;
                arr[k] = arr[i];
            }
        }
        return k+1;
    }
}
