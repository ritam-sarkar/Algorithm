package com.orcl.util;

public class MatrixUtil {

	public static void parseIntMatrix(int [][] a){
		int r = a.length;
		int c = a[0].length;
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
