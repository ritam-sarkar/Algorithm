package com.orcl.search;

/**
 * https://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/
 * @author ritsarka
 * 
 * Input:  [10, 3, 5, 6, 20]
Output: 1200
Multiplication of 10, 6 and 20
 
Input:  [-10, -3, -5, -6, -20]
Output: -90

Input:  [1, -4, 3, -6, 7, 0]
Output: 168
 *
 */
public class TripLetProduct {

	public static void main(String[] args) {
		int arr1[] = {10, 3, 5, 6, 20};
		int arr2[] = {-10, -3, -5, -6, -20};
		int arr3[] = {1, -4, 3, -6, 7, 0};
		System.out.println(findMaxTriplet(arr1));
		System.out.println(findMaxTriplet(arr2));
		System.out.println(findMaxTriplet(arr3));

	}
	private static int findMaxTriplet(int arr[]) {
		int max=Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;
		
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > max) {
				thirdMax = secondMax;
				secondMax = max;	
				max = arr[i];
			}else if(arr[i]>secondMax) {
				thirdMax = secondMax;
				secondMax = arr[i];
			}else if(arr[i]>thirdMax) {
				thirdMax = arr[i];
			}
			if(arr[i] < min) {
				secondMin = min;
				min = arr[i];
			}else if(arr[i] < secondMin) {
				secondMin = arr[i];
			}
		}
		
		return Math.max(max*secondMax*thirdMax, min*secondMin*max);
	}

}
