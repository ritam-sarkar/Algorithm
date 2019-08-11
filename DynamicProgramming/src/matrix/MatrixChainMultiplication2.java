package matrix;

import matrix.util.MatrixUtil;

public class MatrixChainMultiplication2 {

	public static void main(String[] args) {
       
		int p[] = {5,4,6,3,2};
		int n = p.length;
		int m[][] = new int[n][n];
		int s[][] = new int[n][n];
		
		matrixChain(m,s,n,p);
		MatrixUtil.parse(m);
		System.out.println();
		MatrixUtil.parse(s);
		inorder(s,1,n-1);
	}

	private static void matrixChain(int[][] m, int[][] s, int n, int[] p) {
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
		int j,min;
		for(int d=1;d<n-1;d++) {
			for(int i = 1; i<n-d; i++) {
				j = i+d;
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i;k<=j-1;k++) {					
					min = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(min < m[i][j]) {
						m[i][j] = min;
						s[i][j] = k;
					}
				}
			}
		}
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

