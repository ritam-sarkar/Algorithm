package com.orcl.array;
/**
 * 
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 *
 */
public class SpecialStringDemo {

	public static void main(String[] args) {
		System.out.println(substrCount("baadaa"));
	}
	static long substrCount(String s) {
	    long count = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int innerCounter = 1;
	        int counterDown = 0;
	        int counterUp = 1;
	        
	        while (i - innerCounter >= 0 && i + innerCounter < s.length()
	                && s.charAt(i - innerCounter) == s.charAt(i - 1) && s.charAt(i + innerCounter) == s.charAt(i - 1)) {
	            count++;
	            innerCounter++;
	        }

			while (i - counterDown >= 0 && i + counterUp < s.length() && s.charAt(i - counterDown) == s.charAt(i)
					&& s.charAt(i + counterUp) == s.charAt(i)) {
				count++;
				counterDown++;
				counterUp++;
			}
	    }

	    return count + s.length();
	}

}
