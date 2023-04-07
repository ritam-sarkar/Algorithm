package com.orcl.dynamicprogramming.matrix;

import com.orcl.util.MatrixUtil;

/**
 * https://www.geeksforgeeks.org/given-n-x-n-square-matrix-find-sum-sub-squares-size-k-x-k/
 * @author ritsarka
 *
 */
public class SumOfSubSquareMatrix {

	public static void main(String[] args) {

		int[][] mat = { {1, 1, 1, 1, 1},
			            {2, 2, 2, 2, 2},
			            {3, 3, 3, 3, 3},
			            {4, 4, 4, 4, 4},
			            {5, 5, 5, 5, 5}
	                   };
		MatrixUtil.parseIntMatrix(mat);
		int k = 3;
		int n = mat.length;
		int[][] sumMatrix = new int[n-k+1][n-k+1];
		solve(sumMatrix, 0, 0, 0, 0, mat, k);
		MatrixUtil.parseIntMatrix(sumMatrix);
	}

	private static void solve(int[][] sumMatrix, int i, int j, int k, int l, int[][] mat, int limit) {

		int r = mat.length;
		int c = mat[0].length;
		if(i <= r-limit && j <= c-limit) {
			sumMatrix[k][l] = summation(mat, i, j, limit);
			solve(sumMatrix, i+1, j, k+1, l, mat, limit);
			solve(sumMatrix, i, j+1, k, l+1, mat, limit);
		}
	}

	private static int summation(int[][] mat, int r, int c, int limit) {
		int sum =0;
		for(int i =r; i<r+limit; i++) {
			for(int j =c; j<c+limit; j++) {
				sum += mat[i][j];
			}
		}
		return sum;
	}

}
