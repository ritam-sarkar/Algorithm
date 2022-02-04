package com.orcl.array;

import java.util.Arrays;

public class FindMissingPositive {

	public static void main(String[] args) {

		int[] arr1 = {3,4,-1,1};
		int[] arr2 = {1,2,0};
		int[] arr3 = {1,1};
		System.out.println(firstMissingPositive(arr1));
		System.out.println(firstMissingPositive(arr2));
		System.out.println(firstMissingPositive(arr3));

	}
	 public static int firstMissingPositive(int[] nums) {
		    int x = 1;
	        int n = nums.length;	        
	        Arrays.sort(nums);	        
	        for(int i =0; i< n; i++){
	            if(nums[i] > x){
	                return x;
	            }else{
	                if(nums[i] > 0){
	                    if(nums[i] == x){
	                        x++;
	                    }
	                }
	            }
	        }
	        return x;
	    }

}
