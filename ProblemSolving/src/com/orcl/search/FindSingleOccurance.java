package com.orcl.search;

public class FindSingleOccurance {

	public static void main(String[] args) {

		int arr[] = {1,1,4,4,6,6,8,9,9};
        findSingleOccur(arr, 0, arr.length-1);
	}

	/**
	 * Before the odd single occurrence  even index is first element and odd index is repeating element
	 * After the odd single occurrence  odd index is first element and even index is repeating element
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	private static void findSingleOccur(int[] arr, int low, int high) { 
        if(low > high) 
            return; 
        if(low == high) 
        { 
            System.out.println("The required element is "+arr[low]); 
            return; 
        } 
          
        // Find the middle point 
        int mid = (low + high)/2; 
          
        // If mid is even and element next to mid is 
        // same as mid, then output element lies on 
        // right side, else on left side 
        if(mid % 2 == 0) 
        { 
            if(arr[mid] == arr[mid+1]) 
            	findSingleOccur(arr, mid+2, high); 
            else
            	findSingleOccur(arr, low, mid); 
        } 
        // If mid is odd and element before mid is same then the 
        // output element is right side of the mid otherwise at left side of mid        
        else if(mid % 2 == 1) 
        { 
            if(arr[mid] == arr[mid-1]) 
            	findSingleOccur(arr, mid+1, high); 
            else
            	findSingleOccur(arr, low, mid-1); 
        } }

}
