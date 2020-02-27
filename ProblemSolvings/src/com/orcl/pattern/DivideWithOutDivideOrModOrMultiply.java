package com.orcl.pattern;

import java.math.BigInteger;

public class DivideWithOutDivideOrModOrMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(divide(7, -3));
		// System.out.println(divide(-7, -3));
		// System.out.println(divide(-7, 3));
		//System.out.println(divide(-2147483648, -1));
		//System.out.println(divide(-2147483648, -2147483648));
		//System.out.println(divide(-2147483648, 2147483647));
		//System.out.println(divide(2147483647, -2147483648));
		//System.out.println(divide(-2147483648,1));

		// System.out.println(divide(0, 1));
		System.out.println(divide(44, 3));

	}
	
	public static int divide(int dividend, int divisor) {	
		
		return divideIt(dividend, divisor, dividend < 0 ^ divisor < 0);
		
    }
    private static  int divideIt(int dividend, int divisor, boolean negative) {
	
		Long longDividend = Math.abs(Long.valueOf(dividend));
		Long longDivisor = Math.abs(Long.valueOf(divisor));
		if (Math.abs(longDivisor) == 1 ) {
			return checkIt(longDividend, negative);
		}
		Long quotient=0L, temp = 0L;	
		for (long i = 31; i >= 0; --i)  
		{  
		  
		    if (temp + (longDivisor << i) <= longDividend)  
		    {  
		        temp += longDivisor << i;  
		        quotient |= 1L << i;  
		    }  
		}  
		return checkIt(quotient, negative);
	}

	private static int checkIt(Long count, boolean negative) {
		if (!negative) {
			 return count>= (long)Integer.MAX_VALUE? Integer.MAX_VALUE : count.intValue();
		}
		return -count < (long)Integer.MIN_VALUE? Integer.MIN_VALUE : -count.intValue();
	}
}
