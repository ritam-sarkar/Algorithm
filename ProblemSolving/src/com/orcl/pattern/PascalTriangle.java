package com.orcl.pattern;

/**
 * 
 * @author ritsarka
 * 
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
 *
 */
// Values are (row) C (column), row and column starts with 1

/**
 *
 */
public class PascalTriangle {

	
	public static void main(String[] args) {
		
		int n = 5;		
		for(int r =1 ; r <= n; r ++) {
			int print =1;
			for(int c=1; c <= r; c++) {
				System.out.print(print + " ");
				print = print * (r-c)/c;
			}
			System.out.println();
		}
	}
}
