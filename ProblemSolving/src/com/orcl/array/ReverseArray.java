package com.orcl.array;

import com.orcl.util.ArrayUtil;

/**
 * https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 *
 * Input  : arr[] = {1, 2, 3}
 * Output : arr[] = {3, 2, 1}
 *
 * Input :  arr[] = {4, 5, 1, 2}
 * Output : arr[] = {2, 1, 5, 4}
 */
public class ReverseArray {
    public static void main(String[] args) {
       int arr1[] =  {1,2,3,4,5};
       int arr2[] = {1,2,3,4};
       int arr3[] = {1,2};
       reverseInt(arr1);
       ArrayUtil.traverse(arr1);
       reverseInt(arr2);
       ArrayUtil.traverse(arr2);
       reverseInt(arr3);
       ArrayUtil.traverse(arr3);
        System.out.println();
       System.out.println(reverseString("abc"));
       System.out.println(reverseString("abcd"));
    }
    private static void reverseInt(int [] arr){
        int i = 0;
        int j = arr.length-1;
        while (i < j){
            ArrayUtil.swap(arr, i, j);
            i++;
            j--;
        }
    }
    private static String reverseString(String s){
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length-1;
        while (i < j){
            ArrayUtil.swap(arr, i, j);
            i++;
            j--;
        }
        return new String(arr);
    }
}
