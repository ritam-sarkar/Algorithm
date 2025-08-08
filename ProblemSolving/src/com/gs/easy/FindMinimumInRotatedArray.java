package com.gs.easy;

/**
 * For example - Array {3,4,5,6,1,2} returns 1
 * For example - Array {2,1} returns 1
 */
public class FindMinimumInRotatedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3,4,5,6,1,2}));
        System.out.println(findMin(new int[] {7,1,2,3,4,5,6}));
        System.out.println(findMin(new int[] {2}));
        System.out.println(findMin(new int[] {2,1}));
    }
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }

        // At the end, left == right, pointing to the minimum
        return nums[left];
    }

}
