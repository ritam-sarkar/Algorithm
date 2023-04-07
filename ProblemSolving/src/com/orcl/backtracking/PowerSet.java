package com.orcl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* https://leetcode.com/problems/subsets/ */
public class PowerSet {
    public static void main(String[] args) {
        System.out.println("Find power set ");
        int[] arr1 = {1,2,3};
        System.out.println(subsets(arr1));
    }
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
