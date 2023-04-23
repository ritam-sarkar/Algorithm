package com.orcl.array;

import com.orcl.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
 *
 * An array contains both positive and negative numbers in random order.
 * Rearrange the array elements so that all negative numbers appear before all positive numbers.
 * Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
 * Output: -12 -13 -5 -7 -3 -6 11 6 5
 */
public class MoveNegetiveAtBegining<E extends Comparable<E>> {
    public static void main(String[] args) {
        int arr1[] = {-12,11,-13,-5,6,-7,5,-3,-6};
        int arr2[] = {11,23,45,-11,-12,-6};
        int arr3[] = {-14,-15,-16};
        int arr4[] = {14,15,16};
        process(arr1);
        System.out.println("arr1 traverse : ");
        ArrayUtil.traverse(arr1);
        process(arr2);
        System.out.println("arr2 traverse : ");
        ArrayUtil.traverse(arr2);
        process(arr3);
        System.out.println("arr3 traverse : ");
        ArrayUtil.traverse(arr3);
        process(arr4);
        System.out.println("arr4 traverse : ");
        ArrayUtil.traverse(arr4);

    }

    private static void process(int[] arr) {
       int findPositive = 0;
       int findNegetive = (arr.length-1);
       while (findPositive < findNegetive){
           if(arr[findPositive] < 0){
               findPositive++;
           }
           if(arr[findNegetive] > 0){
               findNegetive--;
           }
           if(findPositive < findNegetive && arr[findPositive] > 0 && arr[findNegetive] < 0){
               ArrayUtil.swap(arr, findPositive, findNegetive);
               findPositive ++;
               findNegetive --;
           }
       }
    }

}
