package com.orcl.array;

/**
 * 
 * Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20
*
* https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * 
 * @author ritsarka
 *
 */
public class MaximumSumAlternateNumber {

	public static void main(String[] args) {

		int arr[] = {5,5,10,100,10,5};
		System.out.println(findMax(arr));
	}

	/**
	 * p and q are two counters, p summation of 0, 2 , 4th positions ....
	 * q is summation of  1, 3, 5 positions .....
	 * In the end find maximum of p and q  
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	
	
	private static int findMax(int[] arr) {
		
		int p = arr[0];
		int q = 0;
		for(int i =1;i <arr.length; i++) {
			if(i%2 == 0) {
				p += arr[i];
			}else {
				q += arr[i];
			}
		}
		return Math.max(p, q);
	}

}
