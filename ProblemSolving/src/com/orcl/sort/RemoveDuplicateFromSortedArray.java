package com.orcl.sort;

/**
 * 
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.


 * @author ritsarka
 *
 */
public class RemoveDuplicateFromSortedArray {

	public static void main(String[] args) {

		int arr[] = {0,0,1,1,1,1,2,3,3};
		int newLen = removeDuplicates(arr);
		for(int i = 0; i< newLen; i++) {
			System.out.print(arr[i]+" ");
		}
	}
    public static int removeDuplicates(int[] arr) {
        int n = arr.length;        
    	int index =0;
    	for(int i=1;i<n;i++) {
    		if(arr[i] == arr[i-1]) {
    			arr[i-1] = arr[i];
    		} else {
    			arr[++index] = arr[i];
    		}
    	}
    	return index+1;    	
    }   

}
