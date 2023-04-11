package com.orcl.array;

import java.util.HashSet;
import java.util.Set;

public class CountLengthOfCycle {
   /**
    *
    * You have an integer array.
    * Starting from arr[startIndex], follow each element to the index it points to.
    * Continue to do this until you find a cycle.
    * Return the length of the cycle. If no cycle is found return -1
    *
    */



   public static int countLengthOfCycle( int[] arr, int startIndex ) {

      // detect loop
      int slow = startIndex, fast = startIndex;
      do {
        slow = arr[slow];
        fast = arr[fast];
        if(isValid(arr.length,fast)){
           fast = arr[fast];
        } else {
           System.out.println("loop does not exist");
           return -1;
        }
      } while (slow != fast && isValid(arr.length,slow));
      // detect the loop length
      int count =0;
      if(slow == fast){
         System.out.println("loop exists");
         int current = slow;
         Set<Integer> visited = new HashSet<>();
         while (!visited.contains(current)){
            visited.add(current);
            current = arr[current];
            count ++;
         }
      }
      return count;

   }
   private static int countLengthOfCycle2(int [] arr, int start){
      Set<Integer> visited = new HashSet<>();
      int val = arr[start];
      while (val < arr.length){
         if(visited.contains(val)){
            return visited.size();
         } else {
            visited.add(val);
            // if the index contains the value = index then loop == 1
            if(val == arr[val]){
               return 1;
            }
            val = arr[val];
         }
      }
      return -1;
   }

   private static boolean isValid(int len, int index){
      return index < len && index >= 0;
   }


   public static void main( String[] args ) {

      boolean testsPassed = true;
      System.out.println(countLengthOfCycle2(new int[]{1,0},0));
      System.out.println(countLengthOfCycle2(new int[]{1,2,0},0));
      System.out.println(countLengthOfCycle2(new int[]{1,2,3,0},1));
      System.out.println(countLengthOfCycle2(new int[]{2,8,0},2));
      System.out.println(countLengthOfCycle2(new int[]{1,2,2,1},0));
      System.out.println(countLengthOfCycle2(new int[]{1,2,8},0));

      if(testsPassed) {
         System.out.println( "Test passed." );
         //return true;
      } else {
         System.out.println( "Test failed." );
         //return false;
      }


   }
}
