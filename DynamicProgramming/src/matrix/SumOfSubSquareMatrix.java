package matrix;

import matrix.util.MatrixUtil;
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
		MatrixUtil.parse(mat);
		int k = 3;
		int n = mat.length;
		int[][] sumMatrix = new int[k][k];
		int i=0;
		int j =0;
		int p=0;
		int q =0;
		for(i=0;i <= n-k;i++) {
			for(j=0;j <= n-k;j++) {
				sumMatrix[p][q] = sumMatrix[p][q] + mat[i][j];				
			}
			if(p == k-1) {
				p=0;
			}
			p++;
		}
		System.out.println();
		MatrixUtil.parse(sumMatrix);
	}

}
