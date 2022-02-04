package com.orcl.bitwise;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4

Example 2:

Input: [0,1]
Output: 0

 * @author ritsarka
 *
 */
public class RangeWisebitwiseand {

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5,7));

	}
	public static int rangeBitwiseAnd(int m, int n) {
        int c=0;
        // n is always greater than or equals to m
        if(m==0){
            return 0;
        }
        while(true){
         if(m==n ||m==0){
             break;
         }
         else{
            m>>=1;
            n>>=1;
            c++;
         }
        }
        return c>0?m<<c:m;
    }

}
