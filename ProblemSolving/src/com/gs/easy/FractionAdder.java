package com.gs.easy;

import java.util.Arrays;

/**
 * Given two fractions passed in as int arrays,
 * returns the fraction which is result of adding the two input fractions.
 */

public class FractionAdder {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(addFractions(new int[]{2, 3}, new int[]{1, 3})));
        System.out.println(Arrays.toString(addFractions(new int[]{2, 3}, new int[]{1, 2})));
        System.out.println(Arrays.toString(addFractions(new int[]{2, 3}, new int[]{5, 6})));
    }
    private static int[] addFractions( int[] fraction1, int[] fraction2 ) {
        int a = fraction1[0];
        int b = fraction1[1];
        int c = fraction2[0];
        int d = fraction2[1];
        int numerator = a*d + b*c;
        int denominator = b*d;
        int[] result = new int[2];
        int gcd = numerator >= denominator ? gcd(numerator,denominator) : gcd(denominator,numerator);
        result[0] = numerator / gcd;
        result[1] = denominator / gcd;
        return result;
    }

    /**
     * this method will only work when a >= b
     */
    private static int gcd(int a,int b){
        if(b == 0){
            return a;
        }else {
            return gcd(b,a % b);
        }
    }
}
