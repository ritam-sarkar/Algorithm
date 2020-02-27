package com.orcl.bitwise;

/**
 * 
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]

 */
import com.orcl.util.ArrayUtil;

public class TwoSingleNumber {

	public static void main(String[] args) {

		int arr1[] = {1,2,1,3,2,9};
		ArrayUtil.traverse(singleNumber(arr1));
	}
	public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        int k = 0;
        while(((xor >> k) & 1) != 1) {
            k ++;
        }
        int singleNum1 = 0;
        for(int num : nums) {
            if(((num >> k) & 1) == 1) {
                singleNum1 ^= num;
            }
        }
        return new int[]{singleNum1, xor ^ singleNum1};
    }

}
