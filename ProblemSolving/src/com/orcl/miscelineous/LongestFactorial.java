package com.orcl.miscelineous;

import java.math.BigInteger;

public class LongestFactorial {
    public static void main(String[] args) {
        System.out.println(factorial(new BigInteger("24")));
    }

    private static BigInteger factorial(BigInteger n) {
        if(n.equals(BigInteger.ONE)){
            return BigInteger.ONE;
        }
        System.out.println(2 << 30);
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}

