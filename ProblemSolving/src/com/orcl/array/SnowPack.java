package com.orcl.array;
/*
 ** Instructions to candidate.
 **  1) Given an array of non-negative integers representing the elevations
 **     from the vertical cross section of a range of hills, determine how
 **     many units of snow could be captured between the hills.
 **
 **     See the example array and elevation map below.
 **                                 ___
 **             ___                |   |        ___
 **            |   |        ___    |   |___    |   |
 **         ___|   |    ___|   |   |   |   |   |   |
 **     ___|___|___|___|___|___|___|___|___|___|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **                                 ___
 **             ___                |   |        ___
 **            |   | *   *  _*_  * |   |_*_  * |   |
 **         ___|   | *  _*_|   | * |   |   | * |   |
 **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **
 **     Solution: In this example 13 units of snow (*) could be captured.
 **
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement computeSnowpack() correctly.
 */

import java.io.*;
import java.util.*;

public class SnowPack
{

   private static int computeSnowpack(Integer[] arr){
      Map<Integer,Integer> leftMaxMap = new HashMap<>();
      int leftMax =0;
      int rightMax =0;
      int n = arr.length;
      int snow =0;
      for (int i=1;i<n-1;i++){
         leftMax = Math.max(leftMax,arr[i-1]);
         leftMaxMap.put(i, leftMax);
      }
      for (int i= n-2; i > 0 ; i--){
         int val = arr[i];
         rightMax = Math.max(arr[i+1],rightMax);
         if(val < leftMaxMap.get(i) && val < rightMax){
            snow += Math.min(leftMaxMap.get(i),rightMax)-val;
         }
      }
      return snow;
   }
   /*
    **  Returns true if the tests pass. Otherwise, returns false;
    */
   public static boolean doTestsPass()
   {
      boolean result = true;
      result &= computeSnowpack(new Integer[]{0,1,3,0,1,2,0,4,2,0,3,0}) == 13;
      result &= computeSnowpack(new Integer[]{1,0,4,0,6,0,2,0,5}) == 18;

      return result;
   }

   /*
    **  Execution entry point.
    */
   public static void main(String[] args)
   {
      if(doTestsPass())
      {
         System.out.println("All tests pass");
      }
      else
      {
         System.out.println("Tests fail.");
      }
   }
}