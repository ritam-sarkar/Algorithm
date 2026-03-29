package com.orcl.search;

public class FindMedianSortedArray {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3,8}, new int[]{7,9,10,11}));
        //System.out.println(findMedianSortedArrays(new int[]{1,3,8}, new int[]{7,9,10}));
    }
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Even length
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                // Odd length
                else {
                    return Math.max(left1, left2);
                }

            }
            // Move left
            else if (left1 > right2) {
                high = cut1 - 1;
            }
            // Move right
            else {
                low = cut1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

}
