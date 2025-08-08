package com.gs.easy;

public class PowerOf10 {

    public static void main(String[] args) {
        System.out.println(isPowerOf10(100));
        System.out.println(isPowerOf10(10));
        System.out.println(isPowerOf10(100000));
        System.out.println(isPowerOf10(1003));
        System.out.println(isPowerOf10(5));

    }
    private static boolean isPowerOf10(int n){
        while (n != 1){
            if(n % 10 != 0){
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
