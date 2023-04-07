/**
 * 
 */
package com.orcl.dynamicprogramming.matrix;


import com.orcl.util.MatrixUtil;

/**
 * @author Ritam
 *
 */
public class NQeenProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		if(!findNQueenMatrix(5)){
			System.out.println(" solution does not exist");
		}
		
	}
	private static boolean isSafe(int board[][], int row, int col)
	{
	    int i, j;
	    int n = board.length;
	 
	    /**
	     * We are going to visit all the upper rows which are already filled not the downward rows
	     * 
	     */
	    /* Check perpendicular boxes */
	    for (i = row; i >=0; i--){
	    	 if (board[i][col]==1)
		       return false;
	    }      
	 
	    /* Check upper diagonal on left side */
	    for (i=row, j=col; i>=0 && j>=0; i--, j--){
	    	if (board[i][j]==1)
	            return false;
	    }        
	 
	    /* Check upper diagonal on right side */
	    for (i=row, j=col; i>=0 && j<n; i--, j++){
	       if (board[i][j]==1)
		      return false;
	    }       
	 
	    return true;
	}
	private static boolean findNQueenMatrix(int n) {
		int[][] board = new int[n][n];
		if(solveNQ(board,0)){
			MatrixUtil.parseIntMatrix(board);
			return true;
		}else{
			return false;
		}	
	}	

	private static boolean solveNQ(int[][] board, int row) {
		int n = board.length;	
		if(row == n){
			return true;
		}
		for(int i=0;i<n;i++){
			if(isSafe(board, row, i)){
				board[row][i]=1;
				if(solveNQ(board, row+1)){
					return true;
				}else{
					//backtrack
					board[row][i]=0;
				}
			}
		}
		return false;
	}

}
