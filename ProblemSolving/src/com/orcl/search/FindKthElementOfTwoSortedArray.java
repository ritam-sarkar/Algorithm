package com.orcl.search;

public class FindKthElementOfTwoSortedArray {
    public static void main(String[] args) {
        System.out.println(kthElement(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8 , 10}, 5));
    }
    private static int kthElement(int[] a, int[] b, int k) {
        int n1 = a.length, n2 = b.length;

        // Always binary search on smaller array
        if (n1 > n2) return kthElement(b, a, k);

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];

            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];

            // Valid partition
            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
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

        return -1; // Should never happen
    }
}
