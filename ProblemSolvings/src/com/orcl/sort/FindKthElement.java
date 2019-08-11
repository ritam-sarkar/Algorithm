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
     int[] arr = {10,1,7,2,25,11,14};
     int k =4;
     int n = arr.length;
     int start = 0;
     int end = n-1;
     int partIndex = findPartionIndex(arr, start, end);
     while(partIndex != k-1) {
    	 if(partIndex > k-1) {
    		 partIndex = findPartionIndex(arr, start, partIndex-1);
    	 }else if(partIndex < k-1) {
    		 partIndex = findPartionIndex(arr, partIndex+1, end);
    	 }
     }
     System.out.println(arr[partIndex]);     
	}
	private static int findPartionIndex(int arr[], int start, int end){
		int pivot = arr[start];
		int partIndex = end;
		for(int i=end;i>start;i--) {
			if(arr[i]>=pivot) {
				int temp = arr[i];
				arr[i] = arr[partIndex];
				arr[partIndex] = temp;
				partIndex--;
			}
		}
		int temp = arr[start];
		arr[start] = arr[partIndex];
		arr[partIndex] = temp;
		return partIndex;
	}

}


