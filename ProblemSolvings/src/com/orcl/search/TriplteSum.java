package com.orcl.search;
import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * @author ritsarka
 *
 */
public class TriplteSum {

	public static void main(String[] args) {

		int[] arr = {7,12,-1,-3,-4};
		Arrays.sort(arr);
		int n = arr.length;
		int x = 0;
		for (int i = 0; i < n; i++) {
			int l = i + 1;
			int r = n - 1;
			
			while (l < r) {
			   int sum = arr[i]+arr[l]+arr[r];	
               if(sum == x) {
            	   System.out.println(arr[i]+" "+arr[l]+" "+arr[r]);
            	   l++;
            	   r--;
               }else if(sum < x) {
            	   l++;
               }else {
            	   r--;
               }
			}
			// To stop un necessary iteration
		}		
			
	}

}
