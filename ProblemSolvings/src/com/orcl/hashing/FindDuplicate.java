package com.orcl.hashing;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class FindDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 1, 1, 2, 2, 3, 3, 4,50,50, 65,64};
		findDuplicate(arr);
		//findSingleOccurance();
		
		
	}

	/*private static void findSingleOccurance(int [] arr) {
		
		Set<Integer> set = new HashSet<Integer>();
        for(int i : arr) {
        	
        }
	}*/

	private static void findDuplicate(int[] arr) {

		Set<Integer> set = new HashSet<Integer>();
        for(int i : arr) {
        	if(set.contains(i)) {
        		System.out.println(i);
        	}else {
        		set.add(i);
        	}
        }
	}

}
