package com.orcl.array;

public class MaxSumOfSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {2,1,5,1,3,2,2}, 3));
    }
    private static int maxSubArray(int[] arr, int k){
        int kSum = 0;
        int result = 0;
        for(int i=0;i<k;i++){
            kSum += arr[i];
        }
        result = Math.max(result,kSum);
        for (int i=k; i< arr.length;i++){
            kSum += arr[i] - arr[i-k];
            result = Math.max(result,kSum);
        }
        return result;
    }
}
