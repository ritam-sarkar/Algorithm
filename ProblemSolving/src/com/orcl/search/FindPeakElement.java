package com.orcl.search;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {6, 5, 4, 2 , 1}));
    }
    private static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = (right + left) / 2;
            if(nums[mid] > nums[mid + 1])
                right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
