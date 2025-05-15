package com.orcl.miscelineous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsequitiveSequence {
    public static void main(String[] args) {
        System.out.println(withSort(new int[] {100,4,200,1,3,2}));
        System.out.println(withSort(new int[] {0,3,7,2,5,8,4,6,0,1}));
        System.out.println(withSort(new int[] {0}));
        System.out.println(withSort(new int[] {-1,0}));
        System.out.println(withSort(new int[] {2,3,1}));
        System.out.println(withSort(new int[] {0,0}));
        System.out.println(withSort(new int[] {0,0,-1}));
        System.out.println(withSort(new int[] {}));
        System.out.println(withSort(new int[] {9,1,4,7,3,-1,0,5,8,-1,6}));
    }
    private  static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Only try to build sequence if num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Expand sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;

    }
    private static int withSort(int[] arr) {
        if(arr.length ==0){
            return 0;
        }
        Arrays.sort(arr);
        int result = 0;
        int currLen =1;
        for(int i=1;i<arr.length;i++){
           if(arr[i] == arr[i-1]){
               continue;
           }
           if(arr[i] == arr[i-1]+1){
               currLen++;
           } else {
               result = Math.max(currLen, result);
               currLen = 1;
           }
        }
        return Math.max(result, currLen);
    }
}
