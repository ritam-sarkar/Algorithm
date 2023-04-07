/**
 * 
 */
package com.orcl.dynamicprogramming.matrix;

import java.util.Arrays;

/**
 * @author ritsarka
 *
 */
public class GoldMine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] gold = { { 1, 3, 1, 5 },
				         { 2, 2, 4, 1 }, 
				         { 5, 0, 2, 3 }, 
				         { 0, 6, 1, 2 } };
		int m = gold.length;
		int n = gold[0].length;
		int result = getMaxGold(gold, m, n);
		System.out.println(result);

	}

	static int getMaxGold(int gold[][], int m, int n) {


		int goldTable[][] = new int[m][n];
		for (int col = n - 1; col >= 0; col--) {
			for (int row = 0; row < m; row++) {


				int right = (col == n - 1) ? 0 : goldTable[row][col + 1];


				int right_up = (row == 0 || col == n - 1) ? 0 : goldTable[row - 1][col + 1];


				int right_down = (row == m - 1 || col == n - 1) ? 0 : goldTable[row + 1][col + 1];


				goldTable[row][col] = gold[row][col] + Math.max(right, Math.max(right_up, right_down));
				
			}
		}

        int max = goldTable[0][0];
        int startRow = 0;
		for (int i = 1; i < m; i++) {
			if(goldTable[i][0]>max) {
				max = goldTable[i][0];
				startRow = i;
			}
		}
		printPath(goldTable,startRow,0,goldTable.length,goldTable[0].length);
		return max;
	}

	private static void printPath(int[][] goldTable, int r, int c, int m, int n) {
		int right = (c == n-1) ? 0 : goldTable[r][c + 1];
		int right_up = (r == 0 || c == n-1 )? 0 : goldTable[r-1][c + 1];
		int right_down = (r == m-1 || c == n-1 )? 0 : goldTable[r+1][c + 1];
		int max  = Math.max(right, Math.max(right_up, right_down));
		System.out.print(r+","+c);
		if(max ==0) {
			System.out.println();
			return;
		}else {
			System.out.print(" -> ");
		}
		if(right == max) {
			printPath(goldTable,r , c+1, m, n);
		}
		if(right_up == max) {
			printPath(goldTable, r-1, c+1, m, n);
		}
		if(right_down == max) {
			printPath(goldTable, r+1, c+1, m, n);
		}
		
	}

}
