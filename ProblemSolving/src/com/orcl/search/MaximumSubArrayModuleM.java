package com.orcl.search;

import java.util.TreeSet;

/**
 * 
 * @author ritsarka
 * 
 * Input : arr[] = { 3, 3, 9, 9, 5 }
        m = 7
Output : 6
All sub-arrays and their value:
{ 9 } => 9%7 = 2
{ 3 } => 3%7 = 3
{ 5 } => 5%7 = 5
{ 9, 5 } => 14%7 = 2
{ 9, 9 } => 18%7 = 4
{ 3, 9 } => 12%7 = 5
{ 3, 3 } => 6%7 = 6
{ 3, 9, 9 } => 21%7 = 0
{ 3, 3, 9 } => 15%7 = 1
{ 9, 9, 5 } => 23%7 = 2
{ 3, 3, 9, 9 } => 24%7 = 3
{ 3, 9, 9, 5 } => 26%7 = 5
{ 3, 3, 9, 9, 5 } => 29%7 = 1

Input : arr[] = {10, 7, 18}
        m = 13
Output : 12
The subarray {7, 18} has maximum sub-array
sum modulo 13.
 *
 */
public class MaximumSubArrayModuleM {

	public static void main(String[] args) {
		
		int [] arr = {3,3,9,9,5};
		System.out.println(findMaxModule(arr,7));
	}
	private static int findMaxModule(int[] arr, int m) {
		
		int n = arr.length;
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		int [] sum = new int[n];
		treeSet.add(arr[0]);
		int result = arr[0];
		sum[0] = arr[0];
		for(int i=1;i<n;i++) {
			sum[i] = (sum[i-1] + arr[i])%m;
			int a = treeSet.higher(sum[i]) != null ? treeSet.higher(sum[i]) : 0;
			result = Math.max((sum[i] - a + m)%m, result);
			treeSet.add(sum[i]);
		}
		return result;
	}

}
