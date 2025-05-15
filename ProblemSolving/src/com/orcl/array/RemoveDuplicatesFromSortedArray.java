package com.orcl.array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150 part II
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums =  {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates2(nums);
        System.out.println(nums);
    }

    /**
     * initialize p = 0
     * i is iterating over the array from second element
     * p is pointing to last unique element position
     * @param arr
     * @return
     */
    private static int removeDuplicates(int[] arr) {
        int p=0;
        for(int i=1;i<arr.length;i++){
            if(arr[p]!=arr[i]){
                p++;
                arr[p]=arr[i];
            }
        }
        return p+1;
    }

    private static int removeDuplicates2(int[] arr) {
        int k = 2;
        for (int i = 2; i< arr.length;i++) {
          if(arr[k-2] != arr[i])
              arr[k] = arr[i];
              k++;
        }
        return k;
    }
}
