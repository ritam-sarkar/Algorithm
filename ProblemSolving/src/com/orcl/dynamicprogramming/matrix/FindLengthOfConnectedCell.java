package com.orcl.dynamicprogramming.matrix;

/**
 * 
 * Finding the length of connected cells of 1s (regions) in an matrix of Os and
1s: Given a matrix, each of which may be 1 or 0. The filled cells that are connected form a
region. Two cells are said to be connected if they are adjacent to each other horizontally,
vertically or diagonally. There may be several regions in the matrix. How do you find the
largest region (in terms of number of cells) in the matrix?

Input:        1 1 0 0 0 
              0 1 1 0 0 
              0 0 1 0 1
              1 0 0 0 1
              0 1 0 1 1
Output :  5

              
 *
 */

public class FindLengthOfConnectedCell {

	public static void main(String[] args) {
		
		int[][] input  = {{1 , 1 , 0 , 0 , 0},
				          {0 , 1 , 1 , 0 , 0},
				          {0 , 0 , 1 , 0 , 1},  
				          {1 , 0 , 0 , 0 , 1},
				          {0 , 1 , 0 , 1 , 1}
				          };
		int m = input.length;
		int n = input[0].length;
		int[][] result = new int[m+1][n+1];
		int max = Integer.MIN_VALUE;
		int maxRow = 0;
		int maxColumn =0;
		for(int i=1;i<m;i++) {
			for(int j=1; j<n; j++) {
				if(input[i-1][j-1] != 0) {
					result[i][j] = input[i-1][j-1]+ Math.max(result[i][j-1], Math.max(result[i-1][j-1], result[i-1][j]));
				}
				if(result[i][j] >= max) {
					max = result[i][j];
					maxRow =i-1;
					maxColumn =j-1;
				}				
			}			
		}
		System.out.println("Maximum path length "+max+" Postion "+"("+maxRow+","+maxColumn+")");
				
		

	}
	

}
