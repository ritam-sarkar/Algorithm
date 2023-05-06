package com.orcl.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {
    public static void main(String[] args) {

        int [][] arr1 = {{1,3},{2,6},{8,10},{15,18},{17,20}};
        int [][] arr2 = {{1,4},{0,4}};
        int [][] arr3 = {{1,4},{0,1}};
        //System.out.println(merge(arr1));
        System.out.println(merge(arr2));
        System.out.println(merge(arr3));
    }
    private static int[][] merge(int[][] arr) {
        List<int[]> res = new ArrayList<>();

        if(arr.length == 0 || arr == null){
            return res.toArray(new int[0][]);
        }
        Arrays.sort(arr,(a,b)-> a[0]-b[0]);
        int start = arr[0][0];
        int end = arr[0][1];
        for(int[] i : arr){
            if(i[0] <= end){
                end = Math.max(end,i[1]);
            }else{
                res.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}
