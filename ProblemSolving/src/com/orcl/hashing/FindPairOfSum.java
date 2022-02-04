package com.orcl.hashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author Ritam
 *
 */
public class FindPairOfSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a [] = {1,4,5,2,10};
		int [] b = {14,3,9,5,1};
		List<Integer> c = Arrays.asList(6,41,1,8,46);
		findpairCount(c,47);
	}

	
	private static void findpairCount(List<Integer> list, long k) {
		
      Map<Long,Integer> complementMap = new HashMap<Long,Integer>();
      for(Integer i : list) {
    	  long complement = k-i;
    	  if(complement <0) {
    		  complement = 0-complement;
    	  }
    	  if(complementMap.containsKey((long)i)) {
    		  System.out.println(complementMap.get((long)i)+" "+i);
    	  }else {
    		  complementMap.put(complement, i);
    	  }
      }
      
		
	}

}
