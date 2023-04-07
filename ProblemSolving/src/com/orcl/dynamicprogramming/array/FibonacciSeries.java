package com.orcl.dynamicprogramming.array;

/**
 * Fibonacci series is like this
 * 1, 1, 2, 3, 5, 8, 13 ......
 */
public class FibonacciSeries {

	public static void main(String[] args) {

		fibo(2);
	}
	public static void fibo(int n) {
		
		int a =0;
		int b =1;
		int c =0;
		int sum=a+b;
		if(n ==0 || n ==1) {
			System.out.println(n+" th element is "+n);
			System.out.println("summation is"+n);
		} else {
			for(int i =1 ; i<n ; i++) {
			    c = a+b;
			    a = b;
			    b = c;
			    sum += c;
			}
			System.out.println(n+"th element is "+c);
			System.out.println("Summation is "+sum);
		}		
	}

}
