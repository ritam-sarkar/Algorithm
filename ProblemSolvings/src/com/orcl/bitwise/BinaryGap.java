package com.orcl.bitwise;

/**
 * number 9 has binary representation 1001 and contains a binary gap of length 2. 
 * The number 529 has binary representation 1000010001 and contains two binary gaps:
 *  one of length 4 and one of length 3. The number 20 has binary representation 10100 
 *  and contains one binary gap of length 1. The number 15 has
 *  binary representation 1111 and has no binary gaps.
 * @author ritsarka
 *
 */
public class BinaryGap {

	public static void main(String[] args) {

		System.out.println(binaryGap(529));
		
	}

	private static int binaryGap(int n) {
		
		while(n % 2 == 0) {
			n /=2;			
		}
		int binaryGap =0;
		for(int j=0; n >0 ; n/=2) {
			if(n %2 ==0) {
				j++;
			}else {
				binaryGap = Math.max(j, binaryGap);
				j=0;
			}
		}
		
		return binaryGap;
	}

}
