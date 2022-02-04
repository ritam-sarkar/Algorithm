package com.orcl.array;

import com.orcl.util.ArrayUtil;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 * @author ritsarka
 *
 */
public class LeftRotationOfArray {

	public static void main(String[] args) {

		int arr[] = {1,2,3,4,5};
		leftRotata(arr, 3);
		//ArrayUtil.traverse(arr);
	}
	private static void leftRotata(int[] arr, int d){
		int n = arr.length;
		if(d > n) {
			System.out.println(" Not possible");
		}
		
		// Using space		
		
		int[] arr2 = new int[n];
		int k =0;
		for(int i = d;i< n; i++) {
			arr2[k] = arr[i];
			k++;
		}
		for(int i = 0;i<=d-1;i++) {
			arr2[k] = arr[i];
			k++;
		}		
		ArrayUtil.traverse(arr2);
		System.out.println();
				
		// Using no space
		for(int c = 1;c <=d;c++) {
			int prev = arr[0];
			for(int i=n-1;i>=0;i--) {
				int temp = arr[i];
				arr[i] = prev;
				prev = temp;
			}
		}
		ArrayUtil.traverse(arr);
		
		
		
	}

}
