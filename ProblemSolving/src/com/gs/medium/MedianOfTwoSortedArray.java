package com.gs.medium;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[] {1,2,4} , new int[] {3,5,6,7}));
        //System.out.println(findMedianSortedArrays(new int[] {1,2,4,8} , new int[] {3,5,6,7}));


    }
    public static double findMedianSortedArrays(int[] A, int[] B) {
        // Assuming A is always <= B
        if (A.length > B.length) return findMedianSortedArrays(B, A);

        int m = A.length, n = B.length;
        int low = 0, high = m;

        while (low <= high) {

            int partitionA = (low + high) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA; // remaining partition

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : A[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : A[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : B[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : B[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }

        throw new IllegalArgumentException("Arrays not sorted");
    }

}
