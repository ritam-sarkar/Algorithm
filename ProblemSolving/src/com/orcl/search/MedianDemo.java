package com.orcl.search;
/**
 * 
 */

/**
 * @author Ritam
 *
 *  https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 */
public class MedianDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {2,5,8,9,11,23,24,27};
		int [] arr1 = {1,2, 10, 45, 48};
		int [] arr2 = {39, 41, 43, 44, 47}; 
		int [] arr3 = {10, 16, 40, 54};
		int m = arr1.length;
		int n = arr2.length;
		System.out.println(" Median for two unequal sorted array is "+ medianOfUnEqualSizeArray(arr2, arr3));
	}	
	
	static int medianOfUnEqualSizeArray(int arr1[], int arr2[]) {
		int m = arr1.length;
		int n = arr2.length;
		int m1 =-1;
		int m2 =-1;
		int i =0;
		int j =0;		
		int k = 0;
		while(i<m && j<n && k < (m+n)/2) {
			if(arr1[i] < arr2[j]) {
				m1 = m2;
				m2 = arr1[i];
				i++;
			} else {
				m1 = m2;
				m2 = arr2[j];
				j++;
			}
			k++;
		}
		while(k < (m+n)/2 && i<m) {
			m1 = m2;
			m2 = arr1[i];
			i++;
			k++;
		}
		while(k < (m+n)/2 && j<n) {
			m1 = m2;
			m2 = arr2[j];
			j++;
			k++;
		}	
		if((m+n)%2 ==0) {
			return (m1+m2)/2;
		} else {
			return m2;
		}	      
	    
	}
}


