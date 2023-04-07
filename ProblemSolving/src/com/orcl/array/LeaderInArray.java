package com.orcl.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  An element of array is leader if it is greater than or equal
 *  to all the elements to its right side. The rightmost element is always a leader.
 *  N = 6
 * A[] = {16,17,4,3,5,2}
 * Output: 17 5 2
 * Explanation: The first leader is 17
 * as it is greater than all the elements
 * to its right.  Similarly, the next
 * leader is 5. The right most element
 * is always a leader so it is also
 * included.
 */
public class LeaderInArray {
   public static void main(String[] args) {

      int arr1[] = {1,2,3,4,0};
      leader(arr1);
      
   }

   private static void leader(int[] arr) {
      int n = arr.length;
      int max = Integer.MIN_VALUE;
      List<Integer> leaders = new ArrayList<>();
      for(int i=n-1;i>0;i--){
        if(arr[i] >= max){
           leaders.add(arr[i]);
           max = arr[i];
        }
      }
      Collections.reverse(leaders);
   }
}
