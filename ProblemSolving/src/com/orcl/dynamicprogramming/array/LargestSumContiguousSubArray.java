package com.orcl.dynamicprogramming.array;
/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 
 * @author ritsarka
 *
 */
public class LargestSumContiguousSubArray {

	public static void main(String[] args) {

		int arr[] = {1,-2,-3,2,5};
		int arr2[] = {-6,-2,-3,-2,-5, -3};
		System.out.println("Maximum sum of the contiguous array "+ kadaneAlgo(arr2));
		
	}

	private static int kadaneAlgo(int[] arr) {
		int n = arr.length;		
		int max = arr[0];
		int sum =0;
		for(int i =0 ;i< n; i++) {
			sum += arr[i];
			max = Math.max(max, sum);
			if(sum < 0) {
				sum =0;
			}
		}
		return max;
	}

}
