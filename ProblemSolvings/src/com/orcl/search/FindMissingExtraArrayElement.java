package com.orcl.search;
/**
 * 
 */


/**
 * Input : {2, 4, 6, 8, 9,  10, 12};
           {2, 4, 6, 8, 10, 12};
Output : 4
The first array has an extra element 9.
The extra element is present at index 4.

Input :  {3, 5, 7, 9, 11, 13}
         {3, 5, 7, 11, 13}
Output :  3
 * @author ritsarka
 *
 */
public class FindMissingExtraArrayElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int b[] = {2,4,6,10,14,16};
		int[] a = {2,4,5,6,10,14,16};
      
  	  int pos = findPos(a,b);
  	  System.out.println(pos);

      
	}
    private static int findPos(int[] x, int[] y){
    	if(x.length == y.length){
    		System.out.println(" arrays are equal");
    		return -1;
    	}else{
    		int[] a = x.length > y.length ? x : y;
    		int[] b = x.length < y.length ? x :y;
    		int left = 0;
    		int right = a.length-1;
    		int index = right;
    		while(left<=right){
    			int mid = (left+right)/2;
    			if(a[mid] == b[mid]){
    				left = mid+1;
    			}else{
    				index = mid;
    				right = mid-1;
    			}
    		}
    		return index;
    		
     	}   	
    	
    }
	
}
