package com.orcl.sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orcl.util.ArrayUtil;

public class MinimumSwapForSortingArray {

	public static void main(String[] args) {

		int arr1[] = {7,1,3,2,4,5,6};
		int arr2[] = {4,3,1,2};
		int arr3[] = {1,3,5,2,4,6,7};
		int arr4[] = {4,2,3,1};
		//System.out.println(minimumSwap2(arr1));
		//System.out.println(minimumSwap2(arr2));
		System.out.println(minimumSwap2(arr3));
		//System.out.println(minimumSwap2(arr4));
	}

	static int minimumSwap2(int arr[]){
    int swap =0;
    int n = arr.length;
    for(int i=0; i<n;i++){
    	if(i+1 != arr[i]){
    		int indexToSwap = find(arr, i+1, i+1);
			ArrayUtil.swap(arr,i,indexToSwap);
			swap++;
		}
	 }
    return swap;
	}
	static int find(int arr[], int key, int start){
    int n = arr.length;
    for(int i=start;i<n;i++){
    	if(arr[i] == key){
    		return i;
		}
	 }
    return -1;
	}

}
