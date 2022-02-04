package com.orcl.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * @author ritsarka
 *
 */

/**
 * 
        List<List<Integer>> output = new ArrayList<>();
        HashSet<String> keys = new HashSet<>();
        if (nums == null || nums.length < 4) return output;
        Arrays.sort(nums);
        int l1 = 0, l2=0;
        int h1 = nums.length-1, h2=h1;
        for (; l1<h1-1; l1++){
            for (; h1 > l1+1; h1--){
                if (l1 < h1-1) l2 = l1+1;
                else break;
                if (h1 > l1+1) h2 = h1-1;
                else break;
                while (l2 < h2){
                    int sum = nums[l1] + nums[l2] + nums[h2] + nums[h1];
                    if (sum < target)
                        l2++;
                    else if (sum > target)
                        h2--;
                    else {
                        String key = ""+ nums[l1] + nums[l2] + nums[h2] + nums[h1];
                        if (!keys.contains(key)){
                            output.add(Arrays.asList(new Integer[]{nums[l1], nums[l2], nums[h2], nums[h1]}));
                            keys.add(key);
                        }
                        l2++;
                    }
                }
            }
            h1 = nums.length-1;
        }
        return  output;
        
 * @author ritsarka
 *
 */
public class SumOf4 {

	public static void main(String args[]) {

		int arr[] = {1, 0, -1, 0, -2, 2}; int sum1 =0;
		int arr2[] = {0,0,0,0}; int sum2 = 1;
		int arr3[] = {-3,-1,0,2,4,5}; int sum3 = 0;
		List<List<Integer>> result = fourSum(arr3, sum3);
		result.stream().forEach(l->{
			l.stream().forEach(System.out::print);
			System.out.println();
		});
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {	
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        // Fix the first element and find other three 
        for (int i = 0; i < n - 3; i++)  
        { 
            // Fix the second element and find other two 
            for (int j = i + 1; j < n - 2; j++)  
            { 
                // Fix the third element and find the fourth 
                for (int k = j + 1; k < n - 1; k++)  
                { 
                    // find the fourth 
                    for (int l = k + 1; l < n; l++)  
                    { 
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target)  
                        	result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));  
                    } 
                } 
            } 
        }
		return result; 
	}

	
}
