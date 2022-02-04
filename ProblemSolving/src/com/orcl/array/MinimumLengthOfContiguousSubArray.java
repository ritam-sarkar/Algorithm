package com.orcl.array;

/**
 * Minimum length of the contiguous sub array which  summation is >= k
 * Like {4,2,1,7,8,1,2,8,1,0}  k =8
 * {8} is the minimum length
 * if k =10 then length is 3 {7,8} {2,8} not {8,2} as {2,8} is contiguous
 * 
 * @author ritsarka
 *
 */
public class MinimumLengthOfContiguousSubArray {

	public static void main(String[] args) {

		int arr[] = {4,2,1,7,8,1,2,8,1,0};
		System.out.println(findMinLength(arr, 8));
		
	}

	private static int findMinLength(int[] arr, int sum) {

		int windowStart = 0;
		int n = arr.length;
		int currentSum = 0;
		int minLen = Integer.MAX_VALUE;
		for(int windowEnd = 0; windowEnd < n; windowEnd++) {
			currentSum += arr[windowEnd];
			while(currentSum >= sum) {
				minLen = Math.min(minLen, (windowEnd-windowStart)+1);
				currentSum -= arr[windowStart];				
				windowStart++;				
			}
		}
				
		return minLen;
	}

}
