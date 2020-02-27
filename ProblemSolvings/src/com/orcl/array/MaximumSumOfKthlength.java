package com.orcl.array;
/**
 * Find the maximum contiguous sub array of length k
 * For {4,2,1,7,8,1,2,8,1,0} there are two possible solution 1,7,8 and 7,8,1 which is 16
 * @author ritsarka
 *
 */
public class MaximumSumOfKthlength {

	public static void main(String[] args) {

		int arr[] = {4,2,1,7,8,1,2,8,1,0};
		System.out.println(findMax(arr, 3));
	}

	private static int findMax(int[] arr, int k) {

		int max = Integer.MIN_VALUE;
		int n = arr.length;
		int currentSum = 0;
		for(int i =0; i<n;i++) {
			currentSum += arr[i];
			if(i >= k-1) {
				max = Math.max(currentSum, max);
				currentSum -= arr[i - (k-1)];
			}			
		}
		return max;
	}
	

}
