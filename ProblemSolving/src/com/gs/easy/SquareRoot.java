package com.gs.easy;

public class SquareRoot {
    public static void main(String[] args) {

        //System.out.println(sqrtNewton(144));
        //System.out.println(sqrtNewton(2));
        System.out.println(sqrtNewton(4));
    }


    public static double sqrtNewton(double n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers don't have real square roots.");
        if (n == 0 || n == 1) return n;

        double x = n;
        double epsilon = 1e-3; // 0.001

        while (true) {
            double next = 0.5 * (x + n / x);
            double diff = next-x;
            diff = diff < 0 ? -diff : diff;
            if (diff < epsilon) {
                break;
            }
            x = next;
        }

        // Optionally round for perfect squares
        long rounded = Math.round(x);
        if (Math.abs(rounded * rounded - n) < epsilon) {
            return rounded;
        }
        return x;
    }
}
