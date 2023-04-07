package com.orcl.backtracking;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/combination-sum/ */

/**
 * https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
 *
 */

/**
 * Initially, the index will be 0, target as given and the data structure(vector or list) will be empty.
 *
 * Now there are 2 options viz to pick or not pick the current index element.
 *
 * If you pick the element, again come back at the same index as multiple occurrences of the same element is possible so the target reduces to target – arr[index] (where target -arr[index]>=0)and also insert the current element into the data structure.
 *
 * If you decide not to pick the current element, move on to the next index and the target value stays as it is. Also, the current element is not inserted into the data structure.
 *
 * While backtracking makes sure to pop the last element as shown in the recursion tree below.
 *
 * Keep on repeating this process while index < size of the array for a particular recursion call.
 *
 * You can also stop the recursion when the target value is 0, but here a generalized version without adding too many conditions is considered.
 *
 * Complexity
 * Time complexity:O(2t∗k)O(2^t * k)O(2
 * t
 *  ∗k) where t is the target, k is the average length.
 */


public class CombinationSum {

    public static void main(String[] args) {
        int [] candidates = {2,3,5,6,7};
        System.out.println(combinationSum(candidates,10));
    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sublist=new ArrayList<>();
        List<List<Integer>> list=new ArrayList<>();
        int index=0;
        combination(candidates, target,index,sublist,list);
        return list;
    }
    private static void combination(int[] candidates, int target, int index, List<Integer> sublist, List<List<Integer>> list) {
        if (index== candidates.length){
            if (target==0){
                list.add(new ArrayList<>(sublist));
            }
            return;
        }
        if (candidates[index]<=target){
            sublist.add(candidates[index]);
            //- Taking the same index
            // child tree
            combination(candidates,target-candidates[index],index,sublist,list);
            sublist.remove(sublist.size()-1);
        }
        // sibling tree
        //- We will be increasing the index since above pick didn't make us to our desired answer.So,we will leave it (not pick)
        combination(candidates,target,index+1,sublist,list);
    }

}
