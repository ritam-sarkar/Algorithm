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
		leftRotata(arr, 2);
		ArrayUtil.traverse(arr);
	}
	private static void leftRotata(int[] arr, int d){
		int n = arr.length;
		for(int c = 1;c <=d;c++) {
			int prev = arr[0];
			for(int i=n-1;i>=0;i--) {
				int temp = arr[i];
				arr[i] = prev;
				prev = temp;
			}
		}
		
	}

}
