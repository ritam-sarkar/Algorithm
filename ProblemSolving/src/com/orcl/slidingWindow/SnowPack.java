package com.orcl.slidingWindow;

/*
 ** Instructions to candidate.
 **  1) Given an array of non-negative integers representing the elevations
 **     from the vertical cross section of a range of hills, determine how
 **     many units of snow could be captured between the hills.
 **
 **     See the example array and elevation map below.
 **                                 ___
 **             ___                |   |        ___
 **            |   |        ___    |   |___    |   |
 **         ___|   |    ___|   |   |   |   |   |   |
 **     ___|___|___|___|___|___|___|___|___|___|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **                                 ___
 **             ___                |   |        ___
 **            |   | *   *  _*_  * |   |_*_  * |   |
 **         ___|   | *  _*_|   | * |   |   | * |   |
 **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **
 **     Solution: In this example 13 units of snow (*) could be captured.
 **
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement computeSnowpack() correctly.
 */

public class SnowPack {
    public static void main(String[] args) {

        System.out.println(computeSnowPack(new int[] {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}));//13
        System.out.println(computeSnowPack(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(computeSnowPack(new int[] {1,0,1,0,1})); // 2
        System.out.println(computeSnowPack(new int[] {5})); // 0
        System.out.println(computeSnowPack(new int[] {3,5})); // 0
        System.out.println(computeSnowPack(new int[] {5,3})); // 0
        System.out.println(computeSnowPack(new int[] {2,2,2,2})); // 0
        System.out.println(computeSnowPack(new int[] {1,2,3,4})); // 0
        System.out.println(computeSnowPack(new int[] {4,3,2,1})); // 0

    }

    /**
     *  for every element find left most pick and right most pick
     *  min(leftmost pick , rightmost pick) - element = number of snows on that element
     *  dp first collect left most pick
     *  then dp collect right most pick
     *  and then calculate
     */
    private static int computeSnowPack(int [] arr){
        if(arr.length == 0 || arr.length ==1){
            return 0;
        }
        int n = arr.length;
        int dp[] = new int[n];
        int leftMax = arr[0];
        dp[0] = 0;
        // calculate dp[i] which has leftmost pick value
        for (int i=1;i<n;i++){
            leftMax = Math.max(leftMax,arr[i-1]);
            if(leftMax > arr[i]){
                dp[i] = leftMax;
            }
        }
        int rightMax = arr[n-1];
        dp[n - 1] = 0;
        int totalSnow = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, arr[i + 1]);
            if (rightMax > arr[i]) {
                // dp[i] already contains left pick , we need to find the minimum of left and right pick
                dp[i] = Math.min(dp[i], rightMax);
            } else {
                dp[i] = 0;
            }
            if(dp[i] > arr[i]){
                totalSnow += (dp[i] - arr[i]);
            }
        }

        return totalSnow;

    }
}
