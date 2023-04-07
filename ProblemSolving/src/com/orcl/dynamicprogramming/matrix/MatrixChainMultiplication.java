/**
 * 
 */
package com.orcl.dynamicprogramming.matrix;

import com.orcl.util.MatrixUtil;

/**
 * @author ritsarka
 * 
 * Video description
 * https://www.youtube.com/watch?v=prx1psByp7U
 * https://www.youtube.com/watch?v=eKkXU3uu2zk
 * Formula
 * m[i,j] = min{m[i,k]+m[k+1,j]+p[i-1]*p[k]*p[j]}
 * if i and j are 1 and 4 respectively then k will be 2 and 3,
 * if i and j are 1 and 6 respectively then k will be 2,3,4,5 etc.
 * So i<= k < j
 * s[i][j] = k;
 *
 */
public class MatrixChainMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		/**
		 * A1  X  A2  X   A3  X  A4
		 * 5x4   4x6     6x2    2x7  
		 * p[] is array of dimensions
		 * 
		 */
		int p[] = {3,6,5,8,4};
		int n = p.length;
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		int j,q;
		
		/**
		 * For A1 A2 A3 A4
		 * 1st iteration m[i][j] ==> d = 1, j = i+d , k = i to <j
		 * 1,2  2,3  3,4
		 * 2nd iteration m[i][j] ==> d = 2, j = i+d , k = i to <j
		 * 1,3  2,4  
		 * 3rd iteration m[i][j] ==> d = 3, j = i+d , k = i to <j
		 * 1,4
		 * 
		 */
		
		for(int d =1;d<n-1;d++) {
			for(int i=1;i<n-d;i++) {
				j = i+d;
				m[i][j] = Integer.MAX_VALUE;
				for(int k =i;k<=j-1;k++) {
					q = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		MatrixUtil.parseIntMatrix(m);
		MatrixUtil.parseIntMatrix(s);
		inorder(s, 1, n-1);
		
		
	}
	static void inorder(int s[][],int l,int h)
	 {
		if(l ==h) {
			System.out.print(" A"+h);
			return;
		}			
		int min = s[l][h];		
		System.out.print("(");
		if(l == min) {
			System.out.print(" A"+min);
			inorder(s, min+1, h);
			System.out.print(" )");
		} else if( h == min) {
			inorder(s, l, min-1);
			System.out.print(" A"+min);
			System.out.print(" )");
		} else {
			inorder(s, l, min);
			inorder(s, min+1, h);
			System.out.print(" )");
		}
		
	 }
	

}
