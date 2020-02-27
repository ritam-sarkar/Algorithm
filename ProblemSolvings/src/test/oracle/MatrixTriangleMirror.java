package test.oracle;

import com.orcl.util.MatrixUtil;

public class MatrixTriangleMirror {

	public static void main(String[] args) {

		int[][] mat =  { {1,2,3,4,0},
				         {5,2,9,3,0},
				         {0,7,8,1,2},
				         {9,8,7,6,5},
				         {0,1,2,2,3}				      
				       };
		MatrixUtil.parseIntMatrix(mat);
		int n = mat.length;
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(isDiagonal(i, j, n)) {
					continue;
				}else {
					if(i>j) {						
						int temp = mat[i][j];
						mat[i][j] = mat[i][n-j-1];
						mat[i][n-j-1] = temp;
					}else if(j>i) {
						int temp = mat[i][j];
						mat[i][j] = mat[n-i-1][j];
						mat[n-i-1][j] = temp;
					}
				}
			}
		}
					
		System.out.println();	
		MatrixUtil.parseIntMatrix(mat);
		
	}
	
	private static boolean isDiagonal(int a, int b, int len) {
		if((a == b) || a+b == len-1) {
			return true;
		}
		return false;
	}

}
