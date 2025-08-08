package com.orcl.slidingWindow;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
public class TrapWater {
    public static void main(String[] args) {
        System.out.println(trapWater(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trapWater(new int[] {4,2,0,3,2,5}));
    }
    static int trapWater(int[] arr){
        int leftMax = arr[0];
        int rightMax = arr[arr.length-1];
        int left = 0;
        int right = arr.length-1;
        int water = 0;
        while (left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax,arr[left]);
                water += leftMax - arr[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, arr[right]);
                water += rightMax - arr[right];
            }
        }
        return water;
    }
}
