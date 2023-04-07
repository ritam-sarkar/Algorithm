package com.orcl.dynamicprogramming.array;

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
		System.out.println(" Without dynamic programing max sum is "+findMaxSumWithoutDP(arr3));
	}

/**
 * Kadane's algorithm
 * @param arr
 * @return
 */
	private static int findMaxSumWithoutDP(int[] arr) {
		int max = Integer.MIN_VALUE;
		int start = 0, end =0, currentIndex = 0;
		int currentMax = 0;
		for (int i=0;i<arr.length;i++){
			currentMax = currentMax + arr[i];
			if(max < currentMax){
				max = currentMax;
				start = currentIndex;
				end =i;
			}
			if(currentMax < 0){
				currentMax = 0;
				currentIndex = currentMax+1;
			}
		}
		System.out.print("Start index "+start+" and end index "+end);
		return max;
	}

}
