package com.orcl.search;

public class SearchInInfiniteArray {

	public static void main(String[] args) {

		int arr[] = {4, 6, 7, 10, 12, 15, 16, 20, 27, 30};
		System.out.println(search(arr,0,3,15));
	}
	private static int search(int[] arr, int l, int h, int key) {		
			if(key > arr[h]) {
				l = h+1;
				h = h+3;
				return search(arr, l, h, key);
			}else {
				return binarySearch(arr, l, h, key);
			}		
	}
	private static int binarySearch(int[] arr, int l, int r, int x) {
		int mid =0;
		while (r > l) 
	    { 
	        mid = (l + r)/2; 
	        if (arr[mid] == x) 
	            return mid; 
	        if (arr[mid] > x) 
	            l = mid+1;
	        else {
	        	r = mid-1;
	        }
	    } 
	    return mid;	
	}

}
