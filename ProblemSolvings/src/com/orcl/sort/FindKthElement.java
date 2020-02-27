package com.orcl.sort;
/**
1
5 4 5
2 3 6 7 9
1 4 8 10
Output:
6

First line consists of test cases T. First line of every test case
 consists of 3 integers N, M and K, denoting number of elements in array1,
 number of elements in array2 and K-th element respectively. Second and Third line of every
 test case consists of elements of Array1 and Array2 respectively.
 * @author Ritam
 *
 */

public class FindKthElement {

	public static void main(String[] args) {
     int[] arr1 = {2,3,6,7,9};
     int k =5;
     int arr2[] = {1,4,8,10};
     int m = arr1.length;
     int n = arr2.length;    
     System.out.println(findKthElement(arr1, arr2, m, n, k));   
     
     
	}
	private static int findKthElement(int[] arr1, int[] arr2, int m, int n, int k) {
		 int i=0;
	     int j =0;
	     int result = -1;
		 while(i<m && j <n && k >0) {
	    	 if(arr1[i] < arr2[j]) {
	    		 result = arr1[i];
	    		 i++;
	    		 k--;
	    	 } else {
	    		 result = arr2[j];
	    		 j++;
	    		 k--;
	    	 }
	     }
	     while(k > 0 && i<m) {
    		 result = arr1[i];
	    	 i++;
			 k--; 
	     }
	     while(k > 0 && j<n) {
    		 result = arr2[j];
	    	 j++;
			 k--; 
	     }
		return result;
	}
	
	

}


