package com.orcl.array;

import java.util.ArrayList;
import java.util.List;

public class FindFirstNegativeIntegerInWindow {
    public static void main(String[] args) {
        System.out.println(firstNegative(new int[] {12, -1, -7, 8, 15 , -30, 16, 28,-20},3));
    }
    private static List<Integer> firstNegative(int[] arr, int k){
      List<Integer> list = new ArrayList<>();
      for(int i=0; i<k;i++){
          if(arr[i] < 0){
            list.add(arr[i]);
            break;
          }
      }
      for(int i=k; i<= arr.length; i++){
          if(arr[i-k] < 0){
              list.add(arr[i-k]);
          }
      }

      return list;
    }
}
