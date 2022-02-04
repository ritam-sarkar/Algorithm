package com.orcl.search;

import java.util.Arrays;

public class ClosestThreeSum {

	public static void main(String[] args) {

		int arr1[] = {-1, 2, 1, -4};
		int arr2[] = {1, 1, -1, -1, 3};
		//System.out.println(threeSumClosest(arr1, 2));
		System.out.println(threeSumClosest(arr2, -1));

	}
	public static int threeSumClosest(int[] arr, int target) {
		
		int closest = Integer.MAX_VALUE;
		int closestdiff = Integer.MAX_VALUE;
		Arrays.sort(arr);
		int n = arr.length;
		for(int i = 0; i<n-2 ; i++) {
			int j = i+1;
			int k = n-1;
			while(j<k) {
				int sum = arr[i] + arr[j] +arr[k];
				int diff = target - sum;
				if(Math.abs(diff) < closestdiff) {
					closest = sum;
					closestdiff = Math.abs(diff);
				}
				if(sum > target) {
					k--;
				} else if(sum < target) {
					j++;
				} else {
					return closest;
				}
			}
		}
		return closest;
	}

}
