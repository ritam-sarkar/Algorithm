package com.orcl.search;
/**
 * 
 * Given an array of numbers find the inflection point (index) where the part of the array to the left & to the right of the inflection point (index) have EQUAL sum. If there is no inflection point, you can return -1. 
 * What is the time complexity & space complexity of your algorithm ? Is this the optimal solution?

Example-1: A = [1, 2, 3, 4, 5, 5, 2, 4, 4].

Inflection point = 4, as  A[0]+A[1]+A[2]+A[3] +A[4] = A[5]+A[6]+A[7]+A[8] = 15

Example-2: A = [-4, 3, 2, 14].

Inflection point = -1, there is no left subarray whose sum is equal to right subarray
 */

/**
 * @author ritsarka
 *
 */
public class InflectionPointDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = {1, 2, 3, 4, 5, 5, 2, 4, 4};
		int arr2[] = {-4, 3, 4, 3};
		int arr3[] = {1,2,5,4,5,5,4,4,4};
		int arr4[] = {-2,1,-1};
		int arr5[] = {-4, 3, 2, 14};
		int arr6[] = {2,2,3,3,3,2,2};
		System.out.println(findInflectionIndex(arr2));
		
	}
	private static int findInflectionIndex(int arr[]) {
		int start = 0;
		int n = arr.length;
		int end = n-1;
	    int leftSum = arr[0];
	    int rightSum = arr[n-1];
		while(start < end) {
		   if(leftSum <= rightSum) {			   
			   start++;
			   if(start < end) {
				   leftSum += arr[start];
			   }			   
		   }else if(leftSum > rightSum) {
			   end--;
			   if(start < end) {
				   rightSum += arr[end];
			   }
		   }
		}
		if(leftSum == rightSum) {
			return start == end ? start-1 : start;
		}else {
			return -1;
		}
		
		
	}

}
