package com.orcl.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Example :
 * Input -2,11,-4,13,-5,2
 * Output : 20 of (11,-4,13)
 * 
 * 11+13 = 24 is giving maximum value but they are not contiguous,
 * You cannot change the sequence of the array by sorting
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 * @author ritsarka
 *
 */

public class KadaneProblem {

	public static void main(String[] args) {

		int arr[] = {-2, 11, -4, 13, -5, 2};
		int arr2[] = {4, -1, -2, 1 ,5};
		int arr3[] = {-13,-2,-4,-6,-11,-5};
		System.out.println(findMaxSumWithoutDP(arr));
		System.out.println(practice(arr));
		System.out.println(findMaxSumWithoutDP(arr2));
		System.out.println(practice(arr2));
		System.out.println(findMaxSumWithoutDP(arr3));
		System.out.println(practice(arr3));

	}

/**
 * Kadane's algorithm
 */
	private static int findMaxSumWithoutDP(int[] nums) {
		int maxSoFar = nums[0];
		int currentSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSoFar = Math.max(maxSoFar, currentSum);
		}

		return maxSoFar;
	}
	private static int practice(int[] arr){
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i : arr){
			currSum = Math.max(i, currSum+i);
			maxSum = Math.max(currSum, maxSum);
		}
		return maxSum;
	}

}
