package com.orcl.search;

public class FindMinimumInRotatedAndSortedArray {

	public static void main(String[] args) {

		int arr1[] = {6,2,3,4,5};
		int arr2[] = {4,5,1,2,3};
		int arr3[] = {2, 3, 4, 5, 6, 7, 8, 1};
		System.out.println(findMinimum(arr1, 0, arr1.length-1, Integer.MAX_VALUE));
		System.out.println(findMinimum(arr2, 0, arr2.length-1, Integer.MAX_VALUE));
		System.out.println(findMinimum(arr3, 0, arr3.length-1, Integer.MAX_VALUE));
	}
	private static int findMinimum(int[] arr, int l, int h, int min) {		
		if(l >= h) {
			return Math.min(arr[l], min);
		}
		int mid = (l+h)/2;
		if(arr[l] <= arr[mid]) {
			min = Math.min(min, arr[l]);
		}else {
			min = Math.min(min, arr[mid]);
		}
		min = findMinimum(arr, l, mid-1, min);
		return findMinimum(arr, mid+1, h, min);
	}

}
