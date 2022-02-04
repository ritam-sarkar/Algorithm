package com.orcl.search;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author Ritam
 * https://www.geeksforgeeks.org/queries-counts-array-elements-values-given-range/
 * Input :  arr = [1 3 3 9 10 4] 
         i1 = 1, j1 = 4
         i2 = 9, j2 = 12
Output : 4
         2
The numbers are: 1 3 3 4 for first query
The numbers are: 9 12 for second query

 *
 */
public class CountElementWithinGivenRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      int[] arr = {2,6,4,9,10,15,11,5};
      findElements(arr,7,11);
      
	}

	private static void findElements(int[] arr, int min, int max) {
		Arrays.sort(arr);
		int n = arr.length;
		int l =0; int r = n-1;
		while(l<=r) {
			if(arr[l] < min) {
				l++;
			}else if(arr[r] > max) {
				r--;
			}else {
				printArr(arr,l,r);
				return;
			}
		}
		
	}

	private static void printArr(int[] arr, int l, int r) {

		System.out.println(" numbers are \n");

		for (int i = l; i <= r; i++) {
			System.out.print(arr[i]+" ");
		}
	}
   
	
	

}
