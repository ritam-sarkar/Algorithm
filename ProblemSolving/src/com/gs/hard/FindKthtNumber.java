package com.gs.hard;

public class FindKthtNumber {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] {11,3,1,7,18, 10, 4, 9}, 3));
        System.out.println(findKthSmallest(new int[] {11,3,1,7,18, 10, 4, 9}, 3));
    }
    public static int findKthLargest(int[] nums, int k) {
        int minNums = Integer.MAX_VALUE, maxNums = Integer.MIN_VALUE;
        for(int i: nums) {
            minNums = Math.min(minNums, i);
            maxNums = Math.max(maxNums, i);
        }
        int[] counts = new int[maxNums - minNums + 1];
        for(int i: nums) {
            counts[i-minNums]++;
        }
        for(int i=counts.length - 1; i>=0; i--) {
            k-=counts[i];
            if(k<=0){
                return i+minNums;
            }
        }
        return 0;
    }
    public static int findKthSmallest(int[] nums, int k) {
        int minNums = Integer.MAX_VALUE, maxNums = Integer.MIN_VALUE;

        // Find the min and max in the array
        for (int i : nums) {
            minNums = Math.min(minNums, i);
            maxNums = Math.max(maxNums, i);
        }

        // Create frequency array
        int[] counts = new int[maxNums - minNums + 1];

        for (int i : nums) {
            counts[i - minNums]++;
        }

        // Traverse from smallest to largest
        for (int i = 0; i < counts.length; i++) {
            k -= counts[i];
            if (k <= 0) {
                return i + minNums;
            }
        }

        return 0; // Should not reach here if input is valid
    }
}
