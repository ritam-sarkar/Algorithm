package com.orcl.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * Find k numbers with most occurrences in the given array
 * Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 * @author ritsarka
 *
 */
public class KMostFrequentElement {

	public static void main(String[] args) {

		int[] nums = {4,1,-1,2,-1,2,3};
		int[] nums2 = {1,1,1,2,2,3};
		System.out.println(topKFrequent(nums, 2));
		System.out.println(topKFrequent(nums2, 3));
	}
	public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        if(n == 0 || (n < k)){
            return result;
        }
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i: nums) {
        	countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((k1,k2)-> countMap.get(k1) - countMap.get(k2));
        for(int i : countMap.keySet()) {
        	heap.add(i);
        	if(heap.size() > k) {
        		heap.poll();
        	}
        }
        while(!heap.isEmpty()) {
        	result.add(heap.poll());
        }
        return result;
    }

}
