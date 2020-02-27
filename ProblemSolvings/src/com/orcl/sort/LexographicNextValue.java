package com.orcl.sort;

import com.orcl.util.ArrayUtil;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (i.e, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 * @author ritsarka
 *
 */
public class LexographicNextValue {

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3};
		int[] arr2 = {2, 9, 6, 8, 7, 1};
		nextPermutation(arr1);
		nextPermutation(arr2);
		ArrayUtil.traverse(arr1);
		System.out.println();
		ArrayUtil.traverse(arr2);

		
	}
	public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            ArrayUtil.swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            ArrayUtil.swap(nums, i, j);
            i++;
            j--;
        }
    }   

}
