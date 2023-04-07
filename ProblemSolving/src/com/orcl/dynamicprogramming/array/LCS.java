/**
 * 
 */
package com.orcl.dynamicprogramming.array;

/**
 * @author ritsarka
 * 
 * Longest common subsequence problem not necessary contiguous
 * 
 * Str1 : Longest
 * Str2 : Stone
 * Answer one of length 3
 * 
 * Str1 : ABCDGH
 * Str2 : AEDFHR
 * Answer ADH of length 3
 * 
 *
 */
public class LCS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = "longest";
		String s2 = "stone";
		int m=s1.length();
		int n =s2.length();			
		int lcs[][] = new int[m+1][n+1];
		char a[] = s1.toCharArray();
		char b[] = s2.toCharArray();
		for(int i=1;i<=m;i++) {
			for(int j = 1;j<=n;j++) {
				// if equal then add 1 with left diagonal
				if(a[i-1] == b[j-1]) {
					lcs[i][j] = 1+lcs[i-1][j-1];
				}else {
					// if not eual then take maximum of previous item in the same row and previous item in same column
					lcs[i][j] = max(lcs[i-1][j],lcs[i][j-1]);	
				}
			}
		}		
		System.out.println("Length Longest common subsequence is "+lcs[m][n]);
		int i=m;
		int j=n;
		char [] subseq = new char[lcs[m][n]];
		int k = lcs[m][n];
		while(i>0 && j>0 && k>0) {
			if(lcs[i][j] == lcs[i][j-1]) {
				// if equals to previous elelemnt of the column then move upwards
				j--;
			}else if(lcs[i][j] == lcs[i-1][j]) {
				// if equals to previous element in the same row move left side
				i--;
			}else if(lcs[i][j] > lcs[i-1][j-1]) {
				// if the value came from left diagonal then add the character to the end of the subsequence
				subseq[k-1] = a[i-1];
				i--;
				j--;
				k--;
				
			}
		}
		String output = new  String(subseq);
		System.out.println(" subsequence is "+output);
		
		
	}
	static int max(int a, int b) {
		return a>b?a:b;
	}

}
