package com.orcl.sort;

import com.orcl.util.ArrayUtil;

public class SuprassCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {4, 7, 1, 5, 2, 8};		
		int result[] = new int[arr.length];
		mergeSort(arr,result);
		ArrayUtil.traverse(arr);
		System.out.println();
		ArrayUtil.traverse(result);
		
	}

	private static void mergeSort(int[] arr, int[] result) {

		int n = arr.length;
		if(n ==1) {
			return;
		}		
		int l =0;
		int r = n-1;
		int m = (l+r)/2;
		int left[] = new int[m+1];
		int right[] = new int[r-m];
		int leftResult[] = new int[m+1];
		int rightResult[] = new int[r-m];
		for(int i=0;i<=m;i++) {
			left[i] = arr[i];
		}
		for(int i=m+1;i<n;i++) {
			right[i-(m+1)] = arr[i];
		}
		mergeSort(left, leftResult);
		mergeSort(right, rightResult);
		merge(arr,left,right,result);
		
	}

	private static void merge(int[] arr, int[] left, int[] right, int[] result) {

		int lLen = left.length;
		int rLen = right.length;
		int k1 = 0;
		int k2 = 0;
        int i=0;
        int j=0;
        while(i<lLen && j < rLen) {
        	if(left[i] <= right[j]) {
        		arr[k1++] = left[i++];
        		result[k2++] = result[k2]+1;
        	}else {
        		arr[k1++] = right[j++];
        		k2++;
        	}
        }
        while(i < lLen) {
        	arr[k1++] = left[i++];
        	k2++;
        }
        while(j < rLen) {
        	arr[k1++] = right[j++];
        	k2++;
        }		
	}

}
