package com.orcl.hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Input : arr[] = { 2, 2, 1, 3, 3, 3} 
            m = 3
Output : 1
Remove 1 and both 2's.So, only 3 will be 
left that's why distinct id is 1.

Input : arr[] = { 2, 4, 1, 5, 3, 5, 1, 3} 
            m = 2
Output : 3
Remove 2 and 4 completely. So, remaining ids 
are 1, 3 and 5 i.e. 3

https://www.geeksforgeeks.org/minimum-number-of-distinct-elements-after-removing-m-items/
 * @author ritsarka
 *
 */
public class DistinctIds {

	public static void main(String[] args) {
		
		int arr[] = {2, 4, 1, 5, 3, 5, 1, 3};

		System.out.println(distinctIds(arr,2));
		
	}
	static int distinctIds(int[] arr, int m) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			map.compute(arr[i], (k,v)->{
				v = v==null ? 1 : v+1;
				return v;
			});
		}
	    List<Map.Entry<Integer,Integer>> entryList = map.entrySet().stream().sorted((e1,e2)->e1.getValue().compareTo(e2.getValue())).collect(Collectors.toList());
	    
	    int count =0;
	    int size = map.size();
	    for(Map.Entry<Integer, Integer> entry : entryList) {
	    	if(m >0) {
	    	  if(entry.getValue() <= m) {
	    		  m -= entry.getValue();
	    		  count++;
	    	  }
	    	}
	    }
	    return size-count;
		
	}
	

}
