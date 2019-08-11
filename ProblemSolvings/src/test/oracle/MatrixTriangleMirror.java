package test.oracle;

public class MatrixTriangleMirror {

	public static void main(String[] args) {

		int[][] mat =  { {1,2,3,4,0},
				         {5,2,9,3,0},
				         {0,7,8,1,2},
				         {9,8,7,6,5},
				         {0,1,2,2,3}				      
				       };
		print(mat);
		int n = mat.length;
		/*int midR = n/2;
		int midC = n/2;
		int i = midR-1;
		int j = midR+1;
		int k = midC-1;
		int l = midC+1;
		int cStart = midC;
		int cEnd = midC;
		int rStart = midR;
		int rEnd = midR;
		while(i>=0 && j<n && k >=0 && l<n) {
			int p=0;
			int q=0;
			for(p = cStart,q = rStart;p<=cEnd && q<=rEnd;p++,q++) {				   
			   int t1 = mat[i][p];
			   mat[i][p] = mat[j][p];
			   mat[j][p] = t1;	
			   int t2 = mat[q][k];
			   mat[q][k] = mat[q][l]; 
			   mat[q][l] = t2;
			}
			i--;
			j++;
			k--;
			l++;
			cStart = cStart-1;
			cEnd = cEnd +1; 
			rStart = rStart-1;
			rEnd = rEnd+1;
		}*/
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(isDiagonal(i, j, n)) {
					continue;
				}else {
					if(i>j) {
						int temp = mat[i][j];
						mat[i][j] = mat[i][n-1-j];
						mat[i][n-1-j] = temp;
					}else if(j>i) {
						int temp = mat[i][j];
						mat[i][j] = mat[n-1-i][j];
						mat[n-1-i][j] = temp;
					}
				}
			}
		}
					
		System.out.println();	
		print(mat);
		
	}
	
	static void print(int [][] mat) {
		for(int x = 0;x<mat.length;x++) {
			for(int y=0;y<mat.length;y++) {
				System.out.print(mat[x][y]+" ");
			}
			System.out.println();
		}
	}
	private static boolean isDiagonal(int a, int b, int len) {
		if((a == b) || a+b == len-1) {
			return true;
		}
		return false;
	}

}
