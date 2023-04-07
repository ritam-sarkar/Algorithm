package com.orcl.array;

/**
 * Find second smallest element of an unsorted array
 */
public class SecondSmallestElementOfUnsortedArray {

    public static void main(String[] args) {
        int [] arr = {3,1,6,8,9,2};
        //int [] arr2 = {3,1,6,8,9,1,2};
        int firstSmall = arr[0];
        int secondSmall = Integer.MAX_VALUE;
        for (int i=1; i< arr.length; i++){
            if(arr[i] < firstSmall){
                secondSmall = firstSmall;
                firstSmall = arr[i];
            } else {
                secondSmall = Math.min(secondSmall, arr[i]);
            }

        }
        System.out.println(secondSmall);
    }
}
