package com.orcl.array;
/**
 *  Input:  arr[] = {14, 12, 11, 20};
Output: Length of the longest contiguous subarray is 2
12, 11

Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
Output: Length of the longest contiguous subarray is 5

90, 92, 94, 93, 91
*
*  https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ritam
 *
 */
public class ContiguousSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a1[] = {14, 12, 11, 20};
		int a2[] = {1, 56, 58, 57, 90, 92, 94, 93, 96, 45};
		int a3[] = {2,3,4,12,6,7,8,9,11,10};
		int a4[] = {10, 12, 12, 10, 10, 11, 10};
		System.out.println("find max length of contiguous subarray of a1 "+findMaxLength(a1));
		System.out.println("find max length of contiguous subarray of a2 "+findMaxLength(a2));
		System.out.println("find max length of contiguous subarray of a3 "+findMaxLength(a3));
		System.out.println("find max length of contiguous subarray of a4 "+findMaxLengthByDuplicate(a4));
	}
	
	private static int findMaxLength(int a[]){
		int maxLen =0;
		
		for(int i=0;i<a.length;i++){
			int max = a[i];
			int min = a[i];
			
			for(int j = i+1;j<a.length;j++){
				max = Math.max(max, a[j]);
				min = Math.min(min, a[j]);
				// length of the sub array is equal to (max-min)
				if((max-min)== (j-i)){
					maxLen = Math.max(maxLen,(max-min+1));
					
				}
			}
		}
		return maxLen;
	}
	private static int findMaxLengthByDuplicate(int a[]){
		int maxLen = 0;

		for (int i=0;i<a.length;i++){
			int max = a[i];
			int min = a[i];
			// block added for duplicate
			Set<Integer> duplicate = new HashSet<>();
			duplicate.add(a[i]);
			// block ended for duplicate

			for (int j = i+1; j<a.length;j++){

				// block added for duplicate
				if(duplicate.contains(a[j])){
					break;
				}
				duplicate.add(a[j]);
				// block ended for duplicate

				max = Math.max(a[j],max);
				min = Math.min(a[j],min);
				if((max-min) == (j-i)){
					maxLen = Math.max(maxLen,(max-min+1));
				}
			}
		}
		return maxLen;
	}

}
