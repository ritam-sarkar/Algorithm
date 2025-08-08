package com.gs.easy;

import java.util.*;

/**
 * Return an array containing prime numbers whose product is x
 * Examples:
 * primeFactorization( 6 ) == [2,3]
 * primeFactorization( 5 ) == [5]
 */
public class PrimeFactorization {
    public static void main(String[] args) {
        System.out.println("Prime factors of 100 : " + getPrimeFactors(100));
        System.out.println("Prime factors of 6 : " + getPrimeFactors(6));
        System.out.println("Prime factors of 5 : " + getPrimeFactors(5));
    }

    /**divide n with 2 and add 2 in the list upto n%2 == 0
     * factor start from 3 to sqrt(n)
     * in inner loop n /= i if n%i == 0
     *
     */

    public static List<Integer> getPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        // Step 1: Divide by 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Step 2: Divide by odd numbers
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // Step 3: If n > 2, it's a prime
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }
}
