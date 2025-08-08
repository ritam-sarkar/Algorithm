package com.gs.medium;

/**
 * [1,2,3,4], sum = 6 , summation of [1,2,3,4] = 10 > 6 but summation of [3,4] > 6 and this is the minimum sub array
 * [1,6,1,6,45,3,2,19] sum = 51 , [45,6,1] = 52 > 51, (45,19) is a subsequence not subarray , subarray has to be contiguous
 */
public class MinimumSubArrayExceedsSum {
    public static void main(String[] args) {
        System.out.println(minSubarrayLengthExceedsSum(new int[]{1,6,1,6,45,3,2,19}, 51));
        System.out.println(minSubarrayLengthExceedsSum(new int[]{1,2,3,4}, 6));
        System.out.println(minSubarrayLengthExceedsSum(new int[]{1,2,3,4}, 12));
    }
    public static int minSubarrayLengthExceedsSum(int[] arr, int target) {

        int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        int start = 0, currSum = 0;

        for (int end = 0; end < n; end++) {
            currSum += arr[end];
            while (currSum > target){
                minLength = Math.min(minLength, end-start+1);
                currSum -= arr[start];
                start++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

}
