package com.gs.hard;

/*

 ** There is a staircase with 'n' number of steps. A child
 ** walks by and wants to climb up the stairs, starting at
 ** the bottom step and ascending to the top.instead
 ** of taking 1 step at a time, it will vary between taking
 ** either 1, 2 or 3 steps at a time.
 ** Given 'n' number of steps below method should find
 ** number of
 ** unique combinations the child could traverse.
 ** An example would be countSteps(3) == 4:
 ** 1 1 1
 ** 2 1
 ** 1 2
 ** 3
 */

import java.util.HashMap;
import java.util.Map;

public class Staircase {
    private static  Map<Integer,Long> memo = new HashMap<>();
    public static void main(String[] args) {
        //System.out.println(countSteps(3)); // Expected: 4
        //System.out.println(countSteps(4)); // Expected: 7
        //System.out.println(countSteps(5)); // Expected: 13
        System.out.println(countSteps(45)); // Expected: 13
    }

    /**
     * For n > 3, the number of ways to reach the nth step is
     * the sum of the ways to reach the (n-1)th, (n-2)th, and (n-3)th steps.
     * This is because the child can take a single step from (n-1), double step from (n-2), or triple step from (n-3).
     * @param n
     * @return
     */
    public static long countSteps(int n) {
        if (n<= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        if(memo.containsKey(n)){
          return memo.get(n);
        } else {
            long result = countSteps(n-1)+ countSteps(n-2)+ countSteps(n-3);
            memo.put(n,result);
            return result;
        }
    }


}