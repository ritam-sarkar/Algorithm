package com.orcl.dynamicprogramming.array;
/**
 * Video refernce https://www.youtube.com/watch?v=sVAB0p58tlg
 * Geeks for geeks 
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * @author ritsarka
 *
 */
public class KnapsackProblem {

	public static void main(String[] args) {

		int weight[] = {10,20,30};
		int profit[] = {60,100,120};
		int W = 50;
		findMaximumProfit(weight,profit,W);
		
	}
	/**
	 * 
	 * weight and profit row wise denoted by i
	 * if total weight = W no of column = W+1 denoted by j
	 * Initialize the 0 values for j =0
	 * Initialize i=0 to p[0] for j>0
	 * if w[i] > j means weight of a particular opject is greater than total weight then copy the previous row value.
	 * else max (previous row value, p[i] + mat( remaining weight from previous row))
	 */
	private static void findMaximumProfit(int[] w, int[] p, int W) {

		int n = w.length;		
		int mat[][] = new int[n][W+1];
		for(int i=0;i<n;i++) {
			for(int j =0;j<=W;j++) {
				if(j == 0)
				  mat[i][j] = 0;
				else {
					if(i == 0)
						mat[i][j] = p[i];
					else {
						if(w[i]>j) {
							mat[i][j] = i ==0 ? p[i] : mat[i-1][j];
						}else {
							mat[i][j] = Math.max(mat[i-1][j], p[i]+mat[i-1][j-w[i]]);
						}
					}					
				}				
			}
		}
		System.out.println(" Maximum profit is "+mat[n-1][W]);
		// Now find the array
		int[] ans = new int[n];
		int k =0;
		printSolutionArray(mat,w,p,ans, n-1 ,W, k);
	}

	private static void printSolutionArray(int[][] mat,int[] w,int[] p, int[] ans, int i, int j, int k) {
		if(mat[i][j] == mat[i-1][j]) {
			printSolutionArray(mat,w,p, ans, i-1, j, k);
		}else {
			ans[k] = w[i];
			k++;
			int remainingProfit = mat[i][j] - p[i];			
		}
		
	}

}
