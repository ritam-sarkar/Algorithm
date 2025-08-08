package com.gs.medium;

/* Given base and integer exponent, compute value of base raised to the power of exponent.
 * Can you implement a solution faster than O(exp)?
 */

public class Power {
    public static void main(String[] args) {
        /*System.out.println(myPow(2.0, 10));
        System.out.println(myPow(2.0, -2));
        System.out.println(myPow(2.0, 0));*/
        System.out.println(myPow(5.0, 3));
        System.out.println(myPow(2.0, 8)); // TODO: verify one more time
       // System.out.println(myPow(2.0, -3));
    }

    /**
     * 2 ^4 can be written as 2^2 * 2^2 , no of multiply = 2
     * 2 ^5 can be written as 2^2 * 2^2 * 2 , no of multiply = 3
     * 2 ^ 6 can be written as ( 2^3 * 2^3 ) = (2* 2^2 * 2^3) , no of multiply = 3
     * 2 ^10 = (2^5 * 2^5 ) = (2^4 * 2^4 * 2)
     */
    public static double myPow(double base, int exp) {
        if (exp == 0) return 1.0;

        double result = 1.0;
        long power = Math.abs((long) exp); // Handle Integer.MIN_VALUE
        while (power > 0) {
            if ((power & 1) == 1) { // If last bit is 1 means odd number
                result *= base;
            }
            base *= base; // Square the base
            power >>= 1;  // Divide exp by 2
        }
        return exp < 0 ? 1.0 / result : result;
    }
}
