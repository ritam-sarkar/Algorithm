package array;

import array.util.ArrayUtil;
import matrix.util.MatrixUtil;

public class LongestPalindromeSubsequence {

	public static void main(String[] args) {

		String s = "abcdcbesa";
		int[][] mat = findSolution(s);
		MatrixUtil.parse(mat);		
		findAnswer(mat,s);
	}

	private static void findAnswer(int[][] mat,String s) {

        int n = s.length();		
		int palindromeLen = mat[0][n-1];
		char[] answer = new char[palindromeLen];
		char[] arr = s.toCharArray();
	    solve(mat,arr,0,palindromeLen-1,0,n-1,answer);		
	}

	private static void solve(int[][] mat, char[] arr, int start, int end, int i, int j,char[] answer) {
		
		if(arr[i] == arr[j] && start <= end) {
			if(start == end) {
				answer[start] = arr[i];
				ArrayUtil.traverse(answer);
				return;
			}
			answer[start] = arr[i];
			answer[end] = arr[j];
			start++;
			end--;
			int answerLen = answer.length;
			if(answerLen%2 ==0 && start == (answerLen/2)-1 && end == (answerLen/2)) {
				ArrayUtil.traverse(answer);
				return;
			}
			solve(mat, arr, start, end, i+1, j-1, answer);
			
		}else {
			if(mat[i][j] == mat[i][j-1]) {
				solve(mat, arr, start, end, i, j-1, answer);
			}
			if(mat[i][j] == mat[i+1][j]) {
				solve(mat, arr, start, end, i+1, j, answer);
			}
		}		
	}

	private static void findAnswer(int[][] mat, int i, int j, int start, int end,int[] answer) {
	}

	private static int[][] findSolution(String s) {
		int n = s.length();
		int mat[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(i == j) {
					mat[i][j] =1;
				}
			}
		}
		char[] arr = s.toCharArray();
		/**
		 * sequence of traversal will be 
		 * 0,1  1,2  2,3  3,4 ....
		 * 0,2  1,3 ....
		 * 0,3  1,4 ...
		 *   
		 */
		for(int d=1;d <= n-1;d++) {
			for(int i=0;i < n-d;i++) {
				int j = i+d;
				if(arr[i] == arr[j]) {
					mat[i][j] = 2+mat[i+1][j-1]; 
				}else {
					mat[i][j] = Math.max(mat[i][j-1], mat[i+1][j]);
				}
			}
		}
		return mat;
	}

}
