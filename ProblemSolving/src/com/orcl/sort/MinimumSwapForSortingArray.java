package com.orcl.sort;

import java.util.*;

import com.orcl.util.ArrayUtil;

public class MinimumSwapForSortingArray {

    public static void main(String[] args) {

        int arr1[] = {7, 1, 3, 2, 4, 5, 6};
        int arr2[] = {4, 3, 1, 2};
        int arr3[] = {1, 3, 5, 2, 4, 6, 7};
        int arr4[] = {2, 8, 5, 4};
        //System.out.println(minimumSwap2(arr1));
        //System.out.println(minimumSwap2(arr2));
        System.out.println(minimumSwap2(arr3));
        //System.out.println(minimumSwap2(arr4));
    }

    static int minimumSwap2(int nums[]) {
        // copy array
		int[] arr = new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			arr[i] = nums[i];
		}
		Arrays.sort(arr);

        // Now arr is sorted and nums is unsorted
		int count=0;
		for(int i=0; i<arr.length; i++) {
			if(nums[i] != arr[i])
				count++;
			int item = arr[i];
			int idx = find(nums,item);
			int temp = nums[i];
			nums[i] = nums[idx];
			nums[idx] = temp;
		}
		return count;

    }

    static int find(int arr[], int key) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
		return 0;
    }

}
