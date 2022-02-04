package com.orcl.search;
import java.util.Arrays;

/**
 * 
*  arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}

arr[] = {1, 2, 4}
    x = 8
Output : Not Possible
Whole array sum is smaller than 8.
 * 
 * @author Ritam
 *
 */
public class MaxSubArraySummation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int arr1[] = {1,2,4,5};
     int arr2[] = {1, 10, 5, 2, 7};
     int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
	 System.out.println(smallestSubWithSum(arr1, 10));
	 System.out.println(smallestSubWithSum(arr2, 11));
	 System.out.println(smallestSubWithSum(arr3, 280));
		
	}
	static int smallestSubWithSum(int arr[], int x)
    {
		int n = arr.length;
        //  Initilize length of smallest subarray as n+1
        int min_len = n + 1;
 
        // Pick every element as starting point
        for (int start = 0; start < n; start++)
        {
            // Initialize sum starting with current start
            int curr_sum = arr[start];
 
            // If first element itself is greater
            if (curr_sum > x)
                return 0;
 
            // Try different ending points for curremt start
            for (int end = start + 1; end < n; end++)
            {
                // add last element to current sum
                curr_sum += arr[end];
 
                // If sum becomes more than x and length of
                // this subarray is smaller than current smallest
                // length, update the smallest length (or result)
                if (curr_sum > x && (end - start + 1) < min_len)
                    min_len = (end - start + 1);
            }
        }
        return min_len;
    }
	
}
