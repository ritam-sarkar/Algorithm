package com.orcl.array;

import java.util.*;
/*
https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeInterval {
    public static void main(String[] args) {
        int[][] arr = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};

        System.out.println(merge(arr));
    }
    static int[][] merge(int[][] intervals) {
        // Step 1: sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If merged list is empty OR no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlap → merge
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

}
